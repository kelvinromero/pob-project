package application;

import busines.Facade;
import model.Breed;

public class Create {
    public Create() {
		System.out.println("Creating records");
        try {
            Facade.init();

            createBreeds();

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

    public static void main(String[] args) {
        new Create();
    }

}