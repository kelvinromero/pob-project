package application;

import busines.Facade;
import model.Service;

public class Create {
    public Create() {
		System.out.println("Creating records");
        try {
            Facade.init();

            createServices();

        } catch (Exception e) {
           System.out.println("--->"+e.getMessage());
        }

        Facade.end();
        System.out.println("\nfim do programa !");
    }

    private void createServices() throws Exception {
        Service s;
        s = Facade.createService("banho");
        System.out.println("--->"+s);

        s = Facade.createService("tosa");
        System.out.println("--->"+s);

        s = Facade.createService("banho e tosa");
        System.out.println("--->"+s);

        s = Facade.createService("vermifugação");
        System.out.println("--->"+s);

        s = Facade.createService("vacinação");
        System.out.println("--->"+s);
    }

    public static void main(String[] args) {
        new Create();
    }


}