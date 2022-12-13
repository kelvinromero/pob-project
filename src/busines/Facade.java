package busines;

import java.util.List;

import daojpa.DAO;
import daojpa.DAOBreed;
import daojpa.DAOService;
import daojpa.DAOStatus;
import daojpa.DAOPet;

import model.Service;
import model.Breed;
import model.Status;
import model.Pet;

public class Facade {
    private Facade() {
    }

    private static DAOBreed daoBreed = new DAOBreed();
    private static DAOService daoService = new DAOService();
    private static DAOStatus daoStatus = new DAOStatus();
    private static DAOPet daoPet = new DAOPet();

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
    
    public static List<Breed> readAllBreeds() {
        return daoBreed.readAll();
    }
      
    public static void listBreeds() {
        List<Breed> breeds = readAllBreeds();

        for (Breed breed : breeds) {
            System.out.println(breed);
        }
    }

    public static Service createService(String name) throws Exception {
    	double price;

        switch (name) {
            case "banho":            
                price = 40;            
                break;            
            case "tosa":            
                price = 50;            
                break;            
            case "banho e tosa":            
                price = 80;            
                break;            
            case "vermifugação":            
                price = 20;            
                break;
            default:            
                price = 25;        
                break;            
            }

        DAO.begin();

        if (daoService.read(name) != null) {
            throw new Exception("Service already exists");
        }

        Service s = new Service(name, price);
        daoService.create(s);

        DAO.commit();
                    
        return s;
    }

    public static void deleteService(String serviceName) {
        DAO.begin();

        Service service = daoService.read(serviceName);

        if (service == null) {
            throw new RuntimeException("Esse serviço não existe");
        }

        daoService.delete(service);
        DAO.commit();
    }
    
    public static void updateService(String serviceName, double newPrice) {
        DAO.begin();

        Service service = daoService.read(serviceName);

        if (service == null) {
            throw new RuntimeException("Serviço não existe");
        }
        
        if (newPrice != service.getPrice()) {
            service.setPrice(newPrice);
        }
        
        DAO.commit();
    }

    public static List<Service> readAllServices() {
        return daoService.readAll();
    }

    public static void listServices() {
        List<Service> services = readAllServices();

        for (Service service : services) {
            System.out.println(service);
        }
    }

    public static Status createStatus(String name) throws Exception {
        DAO.begin();

        if (daoStatus.read(name) != null) {
            throw new Exception("Status already exists");
        }

        Status s = new Status(name);
        daoStatus.create(s);

        DAO.commit();

        return s;
    }

    public static void updateStatus(String statusName, String newName) {
        DAO.begin();

        Status status = daoStatus.read(statusName);

        if (status == null) {
            throw new RuntimeException("Status does not exist");
        }

        status.setName(newName);

        DAO.commit();
    }

    public static List<Status> readAllStatus() {
        return daoStatus.readAll();
    }

    public static void listStatus() {
        List<Status> status = readAllStatus();

        for (Status s : status) {
            System.out.println(s);
        }
    }

    public static Pet createPet(String name, String breedName, double weight) throws Exception {
        DAO.begin();

        if (daoPet.read(name) != null) {
            throw new Exception("Pet already exists");
        }

        Breed breed = daoBreed.read(breedName);

        if (breed == null) {
            throw new Exception("Breed does not exist");
        }

        Pet p = new Pet(name, breed, weight);
        daoPet.create(p);

        DAO.commit();

        return p;
    }

    public static void deletePet(String petName) {
        DAO.begin();

        Pet pet = daoPet.read(petName);

        if (pet == null) {
            throw new RuntimeException("Pet does not exist");
        }

        pet.setBreed(null);

        daoPet.delete(pet);

        DAO.commit();
    }

    public static void updatePet(String petName, double newWeight) {
        DAO.begin();

        Pet pet = daoPet.read(petName);

        if (pet == null) {
            throw new RuntimeException("Pet does not exist");
        }

        pet.setWeight(newWeight);

        DAO.commit();
    }

    public static List<Pet> readAllPets() {
        return daoPet.readAll();
    }

    public static void listPets() {
        List<Pet> pets = readAllPets();

        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}

