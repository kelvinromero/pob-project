package model;

import java.util.ArrayList;

public class ServiceOrder {
    
    private Tutor tutor;
    private Pet pet;
    private ArrayList<Service> services;
    private Status status;
    private String date;

    public ServiceOrder(Tutor tutor, Pet pet, Status status) {
        this.tutor = tutor;
        this.pet = pet;
        this.services = new ArrayList<Service>();
        this.status = status;
        this.date = null;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ServiceOrder [tutor=" + tutor + ", pet=" + pet + ", services=" + services + ", status=" + status + ", date=" + date + "]";
    }

}
