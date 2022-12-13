package application;

import busines.Facade;

public class Update {

    public Update() {
        System.out.println("Updating records");

        try {
            Facade.init();
            Facade.updateService("tosa", 30);
            System.out.println("--->Service updated");
            Facade.updatePet("Fido", 16 );
            System.out.println("--->Pet updated");

        } catch (Exception e) {
           System.out.println("--->"+e.getMessage());
        }

        Facade.end();
        System.out.println("\nfim do programa !");
    }
    public static void main(String[] args) {
        new Update();
    }
}