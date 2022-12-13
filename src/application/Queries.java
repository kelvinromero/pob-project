package application;

import busines.Facade;

public class Queries {
    public Queries() {
        System.out.println("Listing records");
        try {
            Facade.init();
            // TODO: add queries
        } catch (Exception e) {
            System.out.println("--->" + e.getMessage());
        }
        Facade.end();
        System.out.println("\nfim do programa !");
    }

    public static void main(String[] args) {
        new Queries();
    }

}