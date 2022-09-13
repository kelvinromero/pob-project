package model;

import java.util.ArrayList;
import java.util.Date;

public class ServiceOrder {
    
    private Tutor tutor;
    private Pet pet;
    private ArrayList<Service> services;
    private Status status;
    private Date date;

    public ServiceOrder(Tutor tutor, Pet pet, ArrayList<Service> services, Status status, Date date) {
        this.tutor = tutor;
        this.pet = pet;
        this.services = services;
        this.status = status;
        this.date = date;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public void addService(Service service) {
        services.add(service);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
