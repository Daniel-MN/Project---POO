package proiectPOO;

import proiectPOO.adapters.ReadTest;
import proiectPOO.adventure.Adventure;
import proiectPOO.logger.MyLogger;

import java.util.Scanner;

public class TestAdventure {

    private static void allTestsFile() {
        Adventure adventure;
        for (int i = 1; i <= 10; i++) {
            MyLogger log = MyLogger.getLogger();
            MyLogger.setWriter(i);
            log.print("\t\t\t\t\t\t\tTestul " + i);
            adventure = ReadTest.goAdventure(i);
            adventure.doAdventure();
        }
    }

    private static void onlyOneTestStdout(int i) {
        MyLogger log = MyLogger.getLogger();
        Adventure adventure = ReadTest.goAdventure(i);
        if (adventure == null) {
            return;
        }
        adventure.doAdventure();
    }

    public static void main(String[] args) {
        System.out.println("Alegeti intre:\n" +
                "1 -> Rularea tuturor testelor in fisiere!\n" +
                "2 -> Rularea unui singur test la stdout!\n");
        System.out.println("Introduceti 1 sau 2 i (i = numarul testului, testele sunt de la 1 la 10)\n");
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        switch (i) {
            case 1:
                allTestsFile();
                break;
            case 2:
                onlyOneTestStdout(s.nextInt());
                break;
            default:
                System.out.println("Introduceti doar 1 sau 2 i (i = numarul testului, testele sunt de la 1 la 10)");
        }

        s.close();
    }
}
