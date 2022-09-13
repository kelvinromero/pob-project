package application;

import com.db4o.ObjectContainer;

import model.*;

public class Update {

    public Update() {
        ObjectContainer manager = Util.createManager();
        update();
        manager.close();
    }

    private void update() {
        updateTutor();
        updatePet();
        updateBreed();
        updateStatus();
        updateService();
        updateServiceOrder();
    }

    private void updateTutor() {
        System.out.println("Updating tutor...");
        ObjectSet<Tutor> tutors = manager.query(Tutor.class);
        Tutor tutor = tutors.next();
        tutor.setName("Tutor 2");
        manager.store(tutor);
    }

    private void updatePet() {
        System.out.println("Updating pet...");
        ObjectSet<Pet> pets = manager.query(Pet.class);
        Pet pet = pets.next();
        pet.setName("Pet 2");
        manager.store(pet);
    }

    private void updateBreed() {
        System.out.println("Updating breed...");
        ObjectSet<Breed> breeds = manager.query(Breed.class);
        Breed breed = breeds.next();
        breed.setName("Breed 2");
        manager.store(breed);
    }

    private void updateStatus() {
        System.out.println("Updating status...");
        ObjectSet<Status> statuses = manager.query(Status.class);
        Status status = statuses.next();
        status.setName("Status 2");
        manager.store(status);
    }

    private void updateService() {
        System.out.println("Updating service...");
        ObjectSet<Service> services = manager.query(Service.class);
        Service service = services.next();
        service.setName("Service 2");
        manager.store(service);
    }

    private void updateServiceOrder() {
        System.out.println("Updating service order...");
        ObjectSet<ServiceOrder> serviceOrders = manager.query(ServiceOrder.class);
        ServiceOrder serviceOrder = serviceOrders.next();
        serviceOrder.setObservation("Observation 2");
        manager.store(serviceOrder);
    }

    public static void main(String[] args) {
        new Update();
    }
}
