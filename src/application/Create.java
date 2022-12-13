package application;

import busines.Facade;
import model.Service;
import model.Breed;
import model.Status;

public class Create {
    public Create() {
		System.out.println("Creating records");
        try {
            Facade.init();
            createBreeds();
            createServices();
            createStatus();

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
    public static void main(String[] args) {
        new Create();
    }


}