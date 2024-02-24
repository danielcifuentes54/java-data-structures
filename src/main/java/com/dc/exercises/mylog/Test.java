package com.dc.exercises.mylog;

public class Test {

    public static void main(String[] args) throws LoggerException{
        Logger logger = Logger.getInstance();
        logger.log(LogLevel.INFO, "First log");
        logger.log(LogLevel.INFO, "First log", LogOutput.JSON_FILE);
        logger.log(LogLevel.INFO, "First log", LogOutput.XML_FILE);
       // logger.log(null, null, null);
    }
}
