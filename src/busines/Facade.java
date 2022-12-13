package busines;

import java.util.List;

import daojpa.DAOBreed;
import model.Breed;
import daojpa.DAO;

public class Facade {
    private Facade() {
    }

    private static DAOBreed daoBreed = new DAOBreed();

    public static void init() {
        DAO.open();
    }

    public static void end() {
        DAO.close();
    }

    public static Breed createBreed(String name) throws Exception {
        DAO.begin();

        if (daoBreed.read(name) != null) {
            throw new Exception("Breed already exists");
        }

        Breed b = new Breed(name);
        daoBreed.create(b);

        DAO.commit();
                
        return b;
    }

    public static List<Breed> readAllBreeds() {
        return daoBreed.readAll();
    }

    public static void deleteBreed(String breedName) {
        DAO.begin();

        Breed breed = daoBreed.read(breedName);

        if (breed == null) {
            throw new RuntimeException("Breed does not exist");
        }

        daoBreed.delete(breed);

        DAO.commit();
    }

    public static void updateBreed(String breedName, String newName) {
        DAO.begin();

        Breed breed = daoBreed.read(breedName);

        if (breed == null) {
            throw new RuntimeException("Breed does not exist");
        }

        breed.setName(newName);

        DAO.commit();
    }

    public static void listBreeds() {
        List<Breed> breeds = readAllBreeds();

        for (Breed breed : breeds) {
            System.out.println(breed);
        }
    }
}
