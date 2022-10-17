package busines;

import java.util.List;

import daodb4o.DAO;
import daodb4o.DAOPet;
import daodb4o.DAOBreed;
import daodb4o.DAOTutor;
import model.Pet;
import model.Breed;
import model.Tutor;

public class Facade {
    private Facade() {}

    private static DAOBreed daoBreed = new DAOBreed();
    private static DAOPet daoPet = new DAOPet();
    private static DAOTutor daoTutor = new DAOTutor();

    public static void init() {
        DAO.open();
    }

    public static void end() {
        DAO.close();
    }

    public static void createBreed(String name) throws Exception {
        Breed breed = new Breed(name);
        daoBreed.create(breed);
    }
    
    public static List<Breed> readAllBreeds() {
        return daoBreed.readAll();
    }

    public static void createPet(String name, String breedName, double weight) throws Exception {
        Breed breed = daoBreed.read(breedName);
        if (breed == null) {
            throw new Exception("Breed not found");
        }
        Pet pet = new Pet(name, breed, weight);
        daoPet.create(pet);
    }

    public static List<Pet> readAllPets() {
    	DAO.begin();
        List<Pet> pets = daoPet.readAll();
        DAO.commit();
        return pets;
    }

    public static void createTutor(String name, String cpf, String phone) throws Exception {
        Tutor tutor = new Tutor(name, cpf, phone);
        daoTutor.create(tutor);
    }

    public static List<Tutor> readAllTutors() {
        return daoTutor.readAll();
    }

    public static void addPetToTutor(int petId, String tutorCPF) throws Exception {
        Pet pet = daoPet.read(petId);
        if (pet == null) {
            throw new Exception("Pet with id " + petId + " not found");
        }
        Tutor tutor = daoTutor.read(tutorCPF);
        if (tutor == null) {
            throw new Exception("Tutor with cpf " + tutorCPF + " not found");
        }
        tutor.addPet(pet);
        daoTutor.update(tutor);
    }

    public static void cleanUpDatabase() {
        daoBreed.deleteAll();
        daoPet.deleteAll();
        daoTutor.deleteAll();   
    }

}
