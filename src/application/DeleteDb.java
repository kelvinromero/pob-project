package application;

import busines.Facade;

public class DeleteDb {
    
    public DeleteDb() {
        System.out.println("Cleaning up database");
        
        try {
            Facade.init();            
            Facade.cleanUpDatabase();
        } catch (Exception e) {
           System.out.println("--->"+e.getMessage());
        }

        Facade.end();
        System.out.println("\nfim do programa !");
    }
    public static void main(String[] args) {
        new DeleteDb();
    }
}