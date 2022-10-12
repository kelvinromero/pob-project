package application;

//import javax.management.Query;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import daodb4o.Util;
import model.Breed;
import model.Pet;
import model.Service;
import model.ServiceOrder;
import model.Status;
import model.Tutor;

public class Update {

	protected ObjectContainer manager;
	
    public Update() {
        manager = Util.createManager();
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
    	Query q = manager.query();
		q.constrain(Tutor.class);  				
		q.descend("name").constrain("Maria");		 
		List<Tutor> resultados = q.execute(); 

		if(resultados.size()>0) {
			Tutor i =  resultados.get(0);
			i.setName("Fatima");
			manager.store(i);
			manager.commit();
			System.out.println("alterou");
		}
		else
			System.out.println("inexistente");
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
        serviceOrder.setDate("02/04/2022");
        manager.store(serviceOrder);
    }

    public static void main(String[] args) {
        new Update();
    }
}
