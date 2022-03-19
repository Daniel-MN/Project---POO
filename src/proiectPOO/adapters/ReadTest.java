package proiectPOO.adapters;

import proiectPOO.adventure.Adventure;
import proiectPOO.trainer.TrainerClub;
import proiectPOO.trainer.TrainerReady;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTest {
    public static Adventure goAdventure(int i) {
        if (i <= 0 || i > 10) {
            System.out.println("Numarul testului este gresit!");
            return null;
        }

        File file = new File("./in/Tests/Test" + i + ".in");
        String trainers = null;
        try {
            Scanner s = new Scanner(file);
            trainers = s.nextLine();
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        }
        
        String[] trainerName = trainers.split(" si ");
        TrainerReady player1 = TrainerClub.getTrainerReady(trainerName[0]);
        TrainerReady player2 = TrainerClub.getTrainerReady(trainerName[1]);
        return new Adventure(player1, player2);
    }
}
