package busines;

import java.util.List;

import daojpa.DAO;
import daojpa.DAOService;
import model.Service;

public class Facade {
    private Facade() {
    }

    private static DAOService daoService = new DAOService();

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

    public static void queryServices() {
        // DAO.begin();

        // List<Service> services = daoService.readAll();

        // for (Service service : services) {
        //     System.out.println(service);
        // }

        // DAO.commit();
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
}
