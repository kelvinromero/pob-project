package application;

import busines.Facade;

public class Queries {
    
    public Queries() {
        System.out.println("Pesquisando serviços");
        
        try {
            Facade.init();

            Facade.queryServices();

        } catch (Exception e) {
           System.out.println("--->"+e.getMessage());
        }

        Facade.end();
        System.out.println("\nfim do programa !");
    }
    public static void main(String[] args) {
        new Queries();
    }
}
