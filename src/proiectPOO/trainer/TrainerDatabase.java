package proiectPOO.trainer;

import proiectPOO.adapters.ReadTrainer;

import java.util.HashMap;

public class TrainerDatabase {
    private static TrainerDatabase database;
    private static HashMap<String, TrainerReady> trainers;

    private TrainerDatabase() {
        setTrainers();
    }

    public static TrainerDatabase Instance() {
        if (database == null) {
            database = new TrainerDatabase();
        }
        return database;
    }

    private void setTrainers() {
        trainers = new HashMap<>();
        HashMap<String, Trainer> trainersNotReady = ReadTrainer.getAll();
        for (Trainer trainer : trainersNotReady.values()) {
            TrainerReady trainerReady = new TrainerReady(trainer);
            trainers.put(trainer.getName(), trainerReady);
        }
    }

    public HashMap<String, TrainerReady> getTrainers() {
        return trainers;
    }
}
