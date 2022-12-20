package application;

import busines.Facade;
import model.ServiceOrder;
import model.Tutor;
import model.Employee;

public class Queries {
    public Queries() {
        try {
            Facade.init();

            System.out.println("Consultando ordens de serviço cujo status é 'agendado':" );
            for (ServiceOrder s: Facade.queryServiceOrdersByStatus("agendado")) {
                System.out.println("--->" + s);
            }

            System.out.println("Consultando tutores com mais de um pet:" );
            for (Tutor t: Facade.queryTutorsWithMoreThanOnePet()) {
                System.out.println("--->" + t);
            }

            System.out.println("Consultando funcionários sem ordem de serviço:" );
            for (Employee e: Facade.queryEmployeesWithoutServiceOrder()) {
                System.out.println("--->" + e);
            }

            System.out.println("Consultando ordens de serviço por empregado e status:" );
            for (ServiceOrder s: Facade.queryServiceOrdersByEmployeeAndStatus("12345678916", "concluído")) {
                System.out.println("--->" + s);
            }
            
        } catch (Exception e) {
            System.out.println("--->" + e.getMessage());
        }
        Facade.end();
        System.out.println("\nfim do programa !");
    }

    public static void main(String[] args) {
        new Queries();
    }

}