package application;

import busines.Facade;

public class Create {
    public Create() {
		System.out.println("Creating records");
        try {
            Facade.init();
            System.out.println("Cleaning up database");
            Facade.cleanUpDatabase();

            System.out.println("Creating breeds");
            Facade.createBreed("Poodle");
            Facade.createBreed("Labrador");
            Facade.createBreed("Pitbull");

            System.out.println("Creating pets");
            Facade.createPet("Fido", "Poodle", 10);
            Facade.createPet("Rex", "Labrador", 20);
            Facade.createPet("Bolt", "Pitbull", 30);

            System.out.println("Creating tutors");
            Facade.createTutor("Joao", "123.456.789-00", "11 99999-9999");
            Facade.createTutor("Maria", "987.654.321-00", "11 99999-9999");
            Facade.createTutor("Jose", "123.123.123-00", "11 99999-9999");

            System.out.println("Adding pets to tutors");
            Facade.addPetToTutor(1, "123.456.789-00");
            Facade.addPetToTutor(2, "123.123.123-00");
            Facade.addPetToTutor(3, "987.654.321-00");


        } catch (Exception e) {
           System.out.println("--->"+e.getMessage());
        }

        Facade.end();
    }

    private void cadastrar() {
        //// creates 3 breeds of dogs
        //Breed breed2 = new Breed("Pitbull");
        //Breed breed3 = new Breed("Pug");

        //// creates 3 pets
        //Pet pet1 = new Pet("Rex", breed1, 4.0);
        //Pet pet2 = new Pet("Bolt", breed2, 9.5);
        //Pet pet3 = new Pet("Bolinha", breed3, 2.0);
//
        //// creates 3 tutors
        //Tutor tutor1 = new Tutor("Joao", "123.456.789-00", "11 99999-9999");
        //Tutor tutor2 = new Tutor("Maria", "987.654.321-00", "11 99999-9998");
        //Tutor tutor3 = new Tutor("Carlos", "111.222.333-00", "11 99999-9997");
//
        //// adds pets to tutors
        //tutor1.addPet(pet1);
        //tutor2.addPet(pet2);
        //tutor3.addPet(pet3);
//
        //// create 3 statuses
        //Status status1 = new Status("Solicitado");
        //Status status2 = new Status("Em andamento");
        //Status status3 = new Status("Finalizado");
//
        //// creates 5 services
        //Service service1 = new Service("Banho", 50.0);
        //Service service2 = new Service("Tosa", 30.0);
        //Service service3 = new Service("Banho e tosa", 70.0);
        //Service service4 = new Service("Vermifugação", 50.0);
        //Service service5 = new Service("Vacinação", 50.0);
//
        //// creates 2 employees
        //Employee employee1 = new Employee("Jose", "123.456.789-00", "11 99999-9999");
        //Employee employee2 = new Employee("Ana", "987.654.321-00", "11 99999-9998");
//
        //// creates 3 service orders
        //ServiceOrder serviceOrder1 = new ServiceOrder(tutor1, pet1, status1, employee1);
        //ServiceOrder serviceOrder2 = new ServiceOrder(tutor2, pet2, status2, employee2);
        //ServiceOrder serviceOrder3 = new ServiceOrder(tutor3, pet3, status3, employee1);
//
        //// adds services to service orders
        //serviceOrder1.addService(service1);
        //serviceOrder1.addService(service2);
        //serviceOrder2.addService(service3);
        //serviceOrder2.addService(service4);
        //serviceOrder3.addService(service5);
        //
        //// adds servicesOrders to employees        
        //employee1.addServiceOrder(serviceOrder1);
        //employee2.addServiceOrder(serviceOrder2);
        //tutor3.addPet(pet3);
        //
        //// persist objects
        //manager.store(breed1);
        //manager.store(breed2);
        //manager.store(breed3);
        //manager.store(pet1);
        //manager.store(pet2);
        //manager.store(pet3);
        //manager.store(tutor1);
        //manager.store(tutor2);
        //manager.store(tutor3);
        //manager.store(status1);
        //manager.store(status2);
        //manager.store(status3);
        //manager.store(service1);
        //manager.store(service2);
        //manager.store(service3);
        //manager.store(service4);
        //manager.store(service5);
        //manager.store(employee1);
        //manager.store(employee2);
        //manager.store(serviceOrder1);
        //manager.store(serviceOrder2);
        //manager.store(serviceOrder3);
        //
        //manager.commit();
    }

    public static void main(String[] args) {
        new Create();
    }

}