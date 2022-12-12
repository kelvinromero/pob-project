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
        Breed breed = new Breed(name);
        daoBreed.create(breed);
        DAO.commit();
                
        return breed;
    }

    public static List<Breed> readAllBreeds() {
        return daoBreed.readAll();
    }
}
