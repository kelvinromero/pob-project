package application;

import busines.Facade;

public class Delete {
    
    public Delete() {
        System.out.println("Deletando serviço");
        
        try {
            Facade.init();

            Facade.deleteService("banho");

            System.out.println("Serviço deletado com sucesso");

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
