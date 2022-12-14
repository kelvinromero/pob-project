package application;

import busines.Facade;
import model.Service;
import model.Breed;
import model.Status;
import model.Pet;
import model.Tutor;
import model.Employee;

import java.util.ArrayList;

public class Create {
    public Create() {
		System.out.println("Creating records");
        try {
            Facade.init();
            createBreeds();
            createServices();
            createStatus();
            createTutorAndPets();
            createEmployees();

        } catch (Exception e) {
           System.out.println("--->"+e.getMessage());
        }

        Facade.end();
        System.out.println("\nfim do programa !");
    }

    private void createBreeds() throws Exception {
        Breed b;
        b = Facade.createBreed("Poddle");
        System.out.println("--->"+b);

        b = Facade.createBreed("labradoodle");
        System.out.println("--->"+b);

        b = Facade.createBreed("Labrador");
        System.out.println("--->"+b);

        b = Facade.createBreed("Pitbull");
        System.out.println("--->"+b);

        b = Facade.createBreed("Pincher");
        System.out.println("--->"+b);
    }

    private void createServices() throws Exception {
        Service s;
        s = Facade.createService("banho");
        System.out.println("--->"+s);

        s = Facade.createService("tosa");
        System.out.println("--->"+s);

        s = Facade.createService("banho e tosa");
        System.out.println("--->"+s);

        s = Facade.createService("vermifugação");
        System.out.println("--->"+s);

        s = Facade.createService("vacinação");
        System.out.println("--->"+s);
    }

    private void createStatus() throws Exception {
        Status s;
        s = Facade.createStatus("agendado");
        System.out.println("--->"+s);

        s = Facade.createStatus("cancelado");
        System.out.println("--->"+s);

        s = Facade.createStatus("concluído");
        System.out.println("--->"+s);

        s = Facade.createStatus("em andamento");
        System.out.println("--->"+s);
    }
    
    private void createTutorAndPets() throws Exception {
        Pet p;
        Tutor t;

        t = Facade.createTutor("João", "12345678910", "982345678");
        System.out.println("--->"+t);
        p = Facade.createPet("Fido", "Poddle", 15, t);
        System.out.println("--->"+p);

        t = Facade.createTutor("Maria", "12345678911", "982345679");
        System.out.println("--->"+t);
        p = Facade.createPet("Fifi", "labradoodle", 12, t);
        System.out.println("--->"+p);

        t = Facade.createTutor("Pedro", "12345678912", "982345680");
        System.out.println("--->"+t);
        p = Facade.createPet("Fufu", "Labrador", 31, t);
        System.out.println("--->"+p);

        t = Facade.createTutor("Beatriz", "12345678913", "982345681");
        System.out.println("--->"+t);
        p = Facade.createPet("Fafa", "Pitbull", 27, t);
        System.out.println("--->"+p);

        p = Facade.createPet("Fefe", "Pincher", 5, t);
        System.out.println("--->"+p);
    }

    private void createEmployees() throws Exception {
        Employee e;
        e = Facade.createEmployee("José", "12345678914", "982345682");
        System.out.println("--->"+e);

        e = Facade.createEmployee("Ana", "12345678915", "982345684");
        System.out.println("--->"+e);

        e = Facade.createEmployee("Joana", "12345678916", "982345684");
        System.out.println("--->"+e);

        e = Facade.createEmployee("Miguel", "12345678917", "982345685");
        System.out.println("--->"+e);
    }
    public static void main(String[] args) {
        new Create();
    }


}