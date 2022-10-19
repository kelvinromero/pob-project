package application;

import java.util.List;

import busines.Facade;
import model.Breed;
import model.Pet;
import model.Service;
import model.ServiceOrder;
import model.Status;
import model.Tutor;

public class Update {
    public Update() {
        System.out.println("Updating...");
        try {
            Facade.init();
            
            String oldEmployeeCPF = "098.654.321-00";
            String newEmployeeCPF = "634.456.789-00";
            
//            String oldEmployeeCPF = "634.456.789-00";
//            String newEmployeeCPF = "098.654.321-00";
            
            int intServiceOrderID = 1;
            ServiceOrder serviceOrder = Facade.readServiceOrder(intServiceOrderID);

            System.out.println("[Before] Service Order: " + serviceOrder);
            Facade.changeEmployeeFromServiceOrder(oldEmployeeCPF, newEmployeeCPF, intServiceOrderID);
            System.out.println("[After] Service Order: " + serviceOrder);


            Facade.end();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done!");
    }

    public static void main(String[] args) {
        new Update();
    }
}
