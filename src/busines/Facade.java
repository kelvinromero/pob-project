package busines;

import java.util.List;

import daojpa.DAO;
import daojpa.DAOBreed;
import daojpa.DAOService;
import daojpa.DAOStatus;
import daojpa.DAOPet;
import daojpa.DAOTutor;
import daojpa.DAOEmployee;
import daojpa.DAOServiceOrder;

import model.Service;
import model.Breed;
import model.Status;
import model.Pet;
import model.Tutor;
import model.Employee;
import model.ServiceOrder;

public class Facade {
    private Facade() {
    }

    private static DAOBreed daoBreed = new DAOBreed();
    private static DAOService daoService = new DAOService();
    private static DAOStatus daoStatus = new DAOStatus();
    private static DAOPet daoPet = new DAOPet();
    private static DAOTutor daoTutor = new DAOTutor();
    private static DAOEmployee daoEmployee = new DAOEmployee();
    private static DAOServiceOrder daoServiceOrder = new DAOServiceOrder();

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

    public static Pet createPet(String name, String breedName, double weight, Tutor tutor) throws Exception {
        DAO.begin();

        if (daoPet.read(name) != null) {
           throw new Exception("Pet already exists");
        }

        Breed breed = daoBreed.read(breedName);

        if (breed == null) {
            throw new Exception("Breed does not exist");
        }

        Pet p = new Pet(name, breed, weight, tutor);
        daoPet.create(p);

        DAO.commit();

        return p;
    }

    public static void deletePet(int petId) {
        DAO.begin();

        Pet pet = daoPet.read(petId);

        if (pet == null) {
            throw new RuntimeException("Pet does not exist");
        }

        daoPet.delete(pet);

        DAO.commit();
    }

    public static void updatePet(int petId, double newWeight) {
        DAO.begin();

        Pet pet = daoPet.read(petId);

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

    public static Tutor createTutor(String name, String document, String phone) throws Exception {
        DAO.begin();

        if (daoTutor.read(document) != null) {
            throw new Exception("Tutor already exists");
        }

        Tutor t = new Tutor(name, document, phone);
        daoTutor.create(t);

        DAO.commit();

        return t;
    }

    public static void deleteTutor(String document) {
        DAO.begin();

        Tutor tutor = daoTutor.read(document);

        if (tutor == null) {
            throw new RuntimeException("Tutor does not exist");
        }

        daoTutor.delete(tutor);

        DAO.commit();

    }

    public static void updateTutor(String document, String newPhone) {
        DAO.begin();

        Tutor tutor = daoTutor.read(document);

        if (tutor == null) {
            throw new RuntimeException("Tutor does not exist");
        }

        tutor.addPhone(newPhone);

        DAO.commit();
    }

    public static List<Tutor> readAllTutors() {
        return daoTutor.readAll();
    }

    public static void listTutors() {
        List<Tutor> tutors = readAllTutors();

        for (Tutor tutor : tutors) {
            System.out.println(tutor);
        }
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

    public static Employee createEmployee(String name, String document, String phone) throws Exception {
        DAO.begin();

        if (daoEmployee.read(document) != null) {
            throw new Exception("Employee already exists");
        }

        Employee e = new Employee(name, document, phone);
        daoEmployee.create(e);

        DAO.commit();

        return e;
    }

    public static void deleteEmployee(String document) {
        DAO.begin();

        Employee employee = daoEmployee.read(document);

        if (employee == null) {
            throw new RuntimeException("Employee does not exist");
        }

        daoEmployee.delete(employee);

        DAO.commit();
    }

    public static void updateEmployee(String document, String newPhone) {
        DAO.begin();

        Employee employee = daoEmployee.read(document);

        if (employee == null) {
            throw new RuntimeException("Employee does not exist");
        }

        employee.addPhone(newPhone);

        DAO.commit();
    }

    public static List<Employee> readAllEmployees() {
        return daoEmployee.readAll();
    }

    public static void listEmployees() {
        List<Employee> employees = readAllEmployees();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void cleanUpDatabase() {
        DAO.begin();
        System.out.println("Cleaning up database aaa");
        daoTutor.deleteAll();
        daoEmployee.deleteAll();
        daoStatus.deleteAll();
        daoService.deleteAll();
        daoPet.deleteAll();
        daoBreed.deleteAll();
        daoServiceOrder.deleteAll();
        DAO.commit();
    }

    public static ServiceOrder createServiceOrder(String tutorDocument,int petId, String statusName, String serviceName, String employeeDocument) throws Exception {
        DAO.begin();

        Tutor tutor = daoTutor.read(tutorDocument);
        if (tutor == null) {
            throw new Exception("Tutor with document " + tutorDocument + " not found");
        }

        Pet pet = daoPet.read(petId);
        if (pet == null) {
            throw new Exception("Pet with id " + petId + " not found");
        }

        Status status = daoStatus.read(statusName);
        if (status == null) {
            throw new Exception("Status with name " + statusName + " not found");
        }

        Service service = daoService.read(serviceName);
        if (service == null) {
            throw new Exception("Service with name " + serviceName + " not found");
        }

        Employee employee = daoEmployee.read(employeeDocument);
        if (employee == null) {
            throw new Exception("Employee with document " + employeeDocument + " not found");
        }

        ServiceOrder serviceOrder = new ServiceOrder(tutor, pet, status, employee);
        daoServiceOrder.create(serviceOrder);
        serviceOrder.addService(service);

        DAO.commit();

        return serviceOrder;
    }

    public static void deleteServiceOrder(int serviceOrderId) {
        DAO.begin();

        ServiceOrder serviceOrder = daoServiceOrder.read(serviceOrderId);

        if (serviceOrder == null) {
            throw new RuntimeException("ServiceOrder does not exist");
        }

        daoServiceOrder.delete(serviceOrder);

        DAO.commit();
    }

    public static void updateServiceOrder(int serviceOrderId, String newStatusName) {
        DAO.begin();

        ServiceOrder serviceOrder = daoServiceOrder.read(serviceOrderId);

        if (serviceOrder == null) {
            throw new RuntimeException("ServiceOrder does not exist");
        }

        Status status = daoStatus.read(newStatusName);
        if (status == null) {
            throw new RuntimeException("Status does not exist");
        }

        serviceOrder.setStatus(status);

        DAO.commit();
    }

    public static List<ServiceOrder> readAllServiceOrders() {
        return daoServiceOrder.readAll();
    }

    public static void listServiceOrders() {
        List<ServiceOrder> serviceOrders = readAllServiceOrders();

        for (ServiceOrder serviceOrder : serviceOrders) {
            System.out.println(serviceOrder);
        }
    }

    public static List<ServiceOrder> queryServiceOrdersByStatus(String statusName) {
        return daoServiceOrder.queryServiceOrdersByStatus(statusName);
    }

    public static List<Tutor> queryTutorsWithMoreThanOnePet() {
        return daoTutor.queryTutorsWithMoreThanOnePet();
    }

    public static List<Employee> queryEmployeesWithoutServiceOrder() {
        return daoEmployee.queryEmployeesWithoutServiceOrder();
    }

    public static List<ServiceOrder> queryServiceOrdersByEmployeeAndStatus(String employeeDocument, String statusName) {
        return daoServiceOrder.queryServiceOrdersByEmployeeAndStatus(employeeDocument, statusName);
    }
}

