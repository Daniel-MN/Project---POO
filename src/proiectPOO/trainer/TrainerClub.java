package proiectPOO.trainer;

public class TrainerClub {
    // returns a trainer (TrainerReady) from the database
    public static TrainerReady getTrainerReady(String name) {
        TrainerDatabase database = TrainerDatabase.Instance();
        TrainerReady trainerReady = database.getTrainers().get(name);
        if (trainerReady == null) {
            System.out.println("Trainer " + name + " does not exist!");
        }
        return trainerReady;
    }
}
