package application;

import busines.Facade;
import model.Breed;

public class Create {
    public Create() {
		System.out.println("Creating records");
        try {
        	Breed b;
            Facade.init();
			System.out.println("cadastrando...");
			b = Facade.createBreed("Poddle");
			System.out.println("--->"+b);
            

        } catch (Exception e) {
           System.out.println("--->"+e.getMessage());
        }

        Facade.end();
        System.out.println("\nfim do programa !");
    }

    public static void main(String[] args) {
        new Create();
    }

}