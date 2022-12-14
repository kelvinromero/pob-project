package application;

import busines.Facade;

public class Delete {
    
    public Delete() {
        System.out.println("Deleting records");
        
        try {
            Facade.init();
            Facade.deletePet(1);
            System.out.println("--->Pet deleted");

            Facade.deleteTutor("12345678912");
            System.out.println("--->Tutor deleted");

            Facade.deleteServiceOrder(1);
            System.out.println("--->ServiceOrder deleted");

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