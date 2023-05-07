package com.tinyurl.tinyurl.dao;
import com.tinyurl.tinyurl.constants.TinyUrlConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class FileDao implements StorageDao  {
    private static final Logger logger= LoggerFactory.getLogger(FileDao.class);
    @Override
    public void addUrl(String userUrl, String tinyUrl) {
        logger.info("addUrl method start..."+userUrl+":"+tinyUrl);
        File tinyUrlFile=new File(TinyUrlConstant.FILE_PATH);
        FileWriter fr=null;
        try{
            fr=new FileWriter(tinyUrlFile, true);
            fr.write(userUrl+"="+tinyUrl+",");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        logger.info("addUrl method end...");
    }

    @Override
    public boolean deleteTinyUrl(String tu) {
        logger.info("deleteTinyUrl method start...");
        FileWriter fr=null;
        Scanner fileScanner=null;
        try {
            fileScanner=new Scanner(new FileReader(TinyUrlConstant.FILE_PATH));
            String content="";
            while(fileScanner.hasNext()){
                String currLine=fileScanner.next();
                String[] split=currLine.split("=");
                if(!split[1].equals(tu))
                    content+=currLine;
            }
            fr=new FileWriter(TinyUrlConstant.FILE_PATH);
            fr.write(content);
            logger.info("deleteTinyUrl method end...");
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fileScanner.close();
        }
    }

    @Override
    public boolean updateUrl(String userUrl, String tinyUrl){
        logger.info("updateUrl method start...");
        FileWriter fr=null;
        Scanner fileScanner=null;
        try {
            fileScanner=new Scanner(new FileReader(TinyUrlConstant.FILE_PATH));
            String content="";
            while(fileScanner.hasNext()) {
                String currLine = fileScanner.next();
                String[] split = currLine.split("=");
                if (split[0].equals(userUrl))
                    content += currLine.replace(split[1], tinyUrl);
                else
                    content += currLine;
            }
            fr=new FileWriter(TinyUrlConstant.FILE_PATH);
            fr.write(content);
            logger.info("updateUrl method end...");
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fileScanner.close();
        }
    }

    @Override
    public String getUrl(String tinyUrl) {
        logger.info("getUrl method start...");
        try(Scanner fileScanner=new Scanner(new FileReader(TinyUrlConstant.FILE_PATH))){
            while(fileScanner.hasNext()){
                String[] keyVal=fileScanner.next().split("=");
                if(keyVal[0].equals(tinyUrl)){
                    logger.info("getUrl method end...");
                    return keyVal[1];
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        logger.info("getUrl method end...");
        return null;
    }

    @Override
    public List<String> getAll() {
        logger.info("getAll start...");
        try(BufferedReader fileBufferReader= new BufferedReader(new FileReader(TinyUrlConstant.FILE_PATH))){
            logger.info("getAll end...");
            return Arrays.stream(fileBufferReader.lines().collect(Collectors.joining(System.lineSeparator())).split(",")).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
