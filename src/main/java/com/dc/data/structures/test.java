package com.dc.data.structures;

import java.util.logging.Level;
import java.util.logging.Logger;

public class test {

    public static void main(String[] args) {
        int sum = 0 ;
        for(int i=1; i<1536; i++){
            if(String.valueOf(i).contains("6")){
                System.out.println(i);
                sum ++;
            }

            Logger myLog = Logger.getAnonymousLogger();
            myLog.log(Level.INFO, "some log");
        }
        System.out.println(sum);
    }
}
