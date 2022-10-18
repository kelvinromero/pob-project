package busines;

import java.util.List;

import daodb4o.DAO;
import daodb4o.DAOPet;
import daodb4o.DAOBreed;
import daodb4o.DAOTutor;
import daodb4o.DAOStatus;
import daodb4o.DAOService;
import daodb4o.DAOEmployee;
import daodb4o.DAOServiceOrder;
import model.Pet;
import model.Breed;
import model.Tutor;
import model.Status;
import model.Service;
import model.Employee;
import model.ServiceOrder;

public class Facade {
    private Facade() {}

    private static DAOBreed daoBreed = new DAOBreed();
    private static DAOPet daoPet = new DAOPet();
    private static DAOTutor daoTutor = new DAOTutor();
    private static DAOStatus daoStatus = new DAOStatus();
    private static DAOService daoService = new DAOService();
    private static DAOEmployee daoEmployee = new DAOEmployee();
    private static DAOServiceOrder daoServiceOrder = new DAOServiceOrder();

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

    public static void createStatus(String name) throws Exception {
        Status status = new Status(name);
        daoStatus.create(status);
    }

    public static List<Status> readAllStatus() {
        return daoStatus.readAll();
    }

    public static void createService(String name, double price) throws Exception {
        Service service = new Service(name, price);
        daoService.create(service);
    }

    public static List<Service> readAllServices() {
        return daoService.readAll();
    }

    public static void createEmployee(String name, String cpf, String phone) throws Exception {
        Employee employee = new Employee(name, cpf, phone);
        daoEmployee.create(employee);
    }

    public static List<Employee> readAllEmployees() {
        return daoEmployee.readAll();
    }

    public static void createServiceOrder(String tutorCPF, int petId, String statusName, String employeeCPF) throws Exception {
        Tutor tutor = daoTutor.read(tutorCPF);
        if (tutor == null) {
            throw new Exception("Tutor with cpf " + tutorCPF + " not found");
        }
        Pet pet = daoPet.read(petId);
        if (pet == null) {
            throw new Exception("Pet with id " + petId + " not found");
        }
        Status status = daoStatus.read(statusName);
        if (status == null) {
            throw new Exception("Status with name " + statusName + " not found");
        }
        Employee employee = daoEmployee.read(employeeCPF);
        if (employee == null) {
            throw new Exception("Employee with cpf " + employeeCPF + " not found");
        }

        ServiceOrder serviceOrder = new ServiceOrder(tutor, pet, status, employee);
        daoServiceOrder.create(serviceOrder);
    }

    public static List<ServiceOrder> readAllServiceOrders() {
        return daoServiceOrder.readAll();
    }

    public static void addServiceToServiceOrder(String serviceName, int serviceOrderId) throws Exception {
        Service service = daoService.read(serviceName);
        if (service == null) {
            throw new Exception("Service with name " + serviceName + " not found");
        }
        ServiceOrder serviceOrder = daoServiceOrder.read(serviceOrderId);
        if (serviceOrder == null) {
            throw new Exception("ServiceOrder with id " + serviceOrderId + " not found");
        }
        serviceOrder.addService(service);
        daoServiceOrder.update(serviceOrder);
    }

    public static void cleanUpDatabase() {
        daoBreed.deleteAll();
        daoPet.deleteAll();
        daoTutor.deleteAll();
        daoStatus.deleteAll();
        daoService.deleteAll();
        daoEmployee.deleteAll();
        daoServiceOrder.deleteAll();
    }

}
