package application;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import model.*;

public class List {

    protected ObjectContainer manager;

    public List() {
        manager = Util.createManager();
        listar();
        manager.close();
    }

    private void listar() {
        listTutors();
        printDivider();
        listPets();
        printDivider();
        listBreeds();
        printDivider();
        listStatus();
        printDivider();
        listServices();
        printDivider();
        listServiceOrders();
    }
    
    private void printDivider() {
        System.out.println("====================================");
    }

    private void listTutors() {
        System.out.println("Tutors:");
        ObjectSet<Tutor> tutors = manager.query(Tutor.class);
        for (Tutor tutor : tutors) {
            System.out.println(tutor);
        }
    }

    private void listPets() {
        System.out.println("Pets:");
        ObjectSet<Pet> pets = manager.query(Pet.class);
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    private void listBreeds() {
        System.out.println("Breeds:");
        ObjectSet<Breed> breeds = manager.query(Breed.class);
        for (Breed breed : breeds) {
            System.out.println(breed);
        }
    }

    private void listStatus() {
        System.out.println("Status:");
        ObjectSet<Status> status = manager.query(Status.class);
        for (Status s : status) {
            System.out.println(s);
        }
    }

    private void listServices() {
        System.out.println("Services:");
        ObjectSet<Service> services = manager.query(Service.class);
        for (Service service : services) {
            System.out.println(service);
        }
    }

    private void listServiceOrders() {
        System.out.println("Service Orders:");
        ObjectSet<ServiceOrder> serviceOrders = manager.query(ServiceOrder.class);
        for (ServiceOrder serviceOrder : serviceOrders) {
            System.out.println(serviceOrder);
        }
    }

    public static void main(String[] args) {
        new List();
    }
}
