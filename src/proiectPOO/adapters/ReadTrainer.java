package proiectPOO.adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import proiectPOO.trainer.Trainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadTrainer {
    public static HashMap<String, Trainer> getAll() {
        HashMap<String, Trainer> trainers = new HashMap<>();

        final File file = new File("./in/Trainer/trainers.json");
        Gson gson = new Gson();
        JsonReader reader;
        try {
            reader = new JsonReader(new FileReader(file));
            ArrayList<Trainer> greatTrainers= gson.fromJson(reader, new TypeToken<ArrayList<Trainer>>(){}.getType());
            for (Trainer trainer : greatTrainers) {
                trainers.put(trainer.getName(), trainer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception: " + e);
        }

        return trainers;
    }
}
