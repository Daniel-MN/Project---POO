package proiectPOO.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MyLogger {
    private static MyLogger logger;
    private static String logType;
    private static FileWriter writer;


    private MyLogger() {
        logType = "stdout";
    }

    public static MyLogger getLogger() {
        if (logger == null)
            logger = new MyLogger();
        return logger;
    }

    public static void setWriter(int i) {
        if (i == 0) {
            logType = "stdout";
            return;
        }

        try {
            MyLogger.writer = new FileWriter("./outAdventure/Test" + i + ".out");
        } catch (IOException e) {
            System.out.println("IOException :: " + e);
        }

        logType = "file";
    }

    public void printFile(String message) throws IOException {
            writer.write(message + "\n");
    }

    public void printConsole(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        if (logType.equals("stdout")) {
            printConsole(message);
            return;
        }

        if (logType.equals("file")) {
            try {
                printFile(message);
            } catch (IOException e) {
                System.out.println("IOException " + e);
            }
            return;
        }

        throw new IllegalArgumentException("Alegeti intre file si stdout!\n");
    }

    public void endWrite() {
        if (logType.equals("file")) {
            try {
                writer.flush();
            } catch (IOException e) {
                System.out.println("IOException " + e);
            }
        }
    }
}
