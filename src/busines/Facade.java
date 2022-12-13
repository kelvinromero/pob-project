package busines;

import java.util.List;

import daojpa.DAO;
import daojpa.DAOService;
import daojpa.DAOBreed;
import model.Service;
import model.Breed;

public class Facade {
    private Facade() {
    }

    private static DAOService daoService = new DAOService();
    private static DAOBreed daoBreed = new DAOBreed();

    public static void init() {
        DAO.open();
    }

    public static void end() {
        DAO.close();
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

      Service Service = new Service(name, price);
      daoService.create(Service);

      DAO.commit();
                
      return Service;
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
}
