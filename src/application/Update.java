package application;

import busines.Facade;

public class Update {

    public Update() {
        System.out.println("Updating records");
        try {
            Facade.init();
            Facade.updateBreed("Pitbull", "Bull Terrier");
            System.out.println("--->Breed updated");
        } catch (Exception e) {
            System.out.println("--->" + e.getMessage());
        }
        Facade.end();
        System.out.println("\nfim do programa !");
    }

    public static void main(String[] args) {
        new Update();
    }

}
