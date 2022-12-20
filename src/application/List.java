package application;

import busines.Facade;

public class List {
    
    public List() {
        System.out.println("Listing records");
        
        try {
            Facade.init();
            Facade.listBreeds();
            Facade.listServices();
            Facade.listStatus();
            Facade.listPets();
            Facade.listTutors();
            Facade.listEmployees();
            Facade.listServiceOrders();

        } catch (Exception e) {
           System.out.println("--->"+e.getMessage());
        }

        Facade.end();
        System.out.println("\nfim do programa !");
    }
    public static void main(String[] args) {
        new List();
    }
}