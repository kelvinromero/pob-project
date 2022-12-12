package application;

import busines.Facade;

public class Update {

    public Update() {
        System.out.println("Atualizando serviço(s)");

        try {
            Facade.init();

            Facade.updateService("tosa", 30);

            System.out.println("Serviço(s) atualizado(s) com sucesso");

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
