package application;

import busines.Facade;

public class Delete {
    
    public Delete() {
        System.out.println("Deleting records");
        
        try {
            Facade.init();
            Facade.deletePet("Fido");
            System.out.println("--->Pet deleted");

        } catch (Exception e) {
           System.out.println("--->"+e.getMessage());
        }

        Facade.end();
        System.out.println("\nfim do programa !");
    }
    public static void main(String[] args) {
        new Delete();
    }
}