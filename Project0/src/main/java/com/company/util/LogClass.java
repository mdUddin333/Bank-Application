package com.company.util;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogClass {


    static Logger logger = LogManager.getLogger(LogClass.class);

    public static void LogIt(String option,String msg){

        switch (option){
            case "debug":
                logger.debug(msg);
                break;
            case "warn":
                logger.warn(msg);
                break;
            case "error":
                logger.error(msg);
                break;
            case "fatal":
                logger.fatal(msg);
                break;
            case "info":
                logger.info(msg);
                break;
            case "trace":
                logger.trace(msg);
                break;
            default:
                System.out.println("Logger..........");
        }

    }

}
