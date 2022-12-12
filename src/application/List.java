package application;

import busines.Facade;

public class List {
    
    public List() {
        System.out.println("Listando serviços");
        
        try {
            Facade.init();

            Facade.listServices();

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
