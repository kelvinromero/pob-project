package application;

import busines.Facade;
import model.Service;
import model.Breed;

public class Create {
    public Create() {
		System.out.println("Creating records");
        try {
            Facade.init();
            createServices();
            createBreeds();

        } catch (Exception e) {
           System.out.println("--->"+e.getMessage());
        }

        Facade.end();
        System.out.println("\nfim do programa !");
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

    public static void main(String[] args) {
        new Create();
    }


}