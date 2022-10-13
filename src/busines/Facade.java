package busines;

import java.util.List;

import daodb4o.DAO;
import daodb4o.DAOPet;
import daodb4o.DAOBreed;
import model.Pet;
import model.Breed;

public class Facade {
    private Facade() {}

    private static DAOBreed daoBreed = new DAOBreed();
    private static DAOPet daoPet = new DAOPet();

    public static void initialize() {
        DAO.open();
    }

    public static void finalize() {
        DAO.close();
    }

    public static List<Pet> readAllPets() {
    	DAO.begin();
        List<Pet> pets = daoPet.readAll();
        DAO.commit();
        return pets;
    }

    public static List<Breed> readAllBreeds() {
        return daoBreed.readAll();
    }

}
