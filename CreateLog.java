package com.github.ybsahan.logcreator;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CreateLog {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger("CityLogFile");
        FileHandler fh;
        



        try {
                //create logfile

            fh = new FileHandler("/home/ybsahan/IdeaProjects/kafkabeginner/src/main/java/com/github/ybsahan/logcreator/CityLogFile.log");
            logger.addHandler(fh);

            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

                //creating data into logfile manually
            logger.info( new java.util.Date() + "INFO" + "İstanbul"+ "Hello-From-İstanbul" + "\n");
            logger.info( new java.util.Date() + "FATAL" + "TOKYO"+ "Hello-From-Tokyo" + "\n");
            logger.info( new java.util.Date() + "INFO" + "İstanbul"+ "Hello-From-İstanbul" + "\n");
            logger.info( new java.util.Date() + "ERROR" + "İstanbul"+ "Hello-From-İstanbul");


        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
