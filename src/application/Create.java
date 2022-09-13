package application;

import com.db4o.ObjectContainer;

import model.Breed;
import model.Pet;
import model.Tutor;

public class Create {
	
	protected ObjectContainer manager;
	
    public Create() {
		manager = Util.createManager();
		cadastrar();
		manager.close();

		System.out.println("end of all creation");
    }

    private void cadastrar() {
        // creates 3 breeds of dogs
        Breed breed1 = new Breed("Poodle");
        Breed breed2 = new Breed("Pitbull");
        Breed breed3 = new Breed("Pug");

        // creates 3 pets
        Pet pet1 = new Pet("Rex", breed1, 4.0);
        Pet pet2 = new Pet("Bolt", breed2, 9.5);
        Pet pet3 = new Pet("Bolinha", breed3, 2.0);

        // creates 3 tutors
        Tutor tutor1 = new Tutor("Joao", "123.456.789-00", "11 99999-9999");
        Tutor tutor2 = new Tutor("Maria", "987.654.321-00", "11 99999-9998");
        Tutor tutor3 = new Tutor("Carlos", "111.222.333-00", "11 99999-9997");

        // adds pets to tutors
        tutor1.addPet(pet1);
        tutor2.addPet(pet2);
        tutor3.addPet(pet3);
        
    }

    public static void main(String[] args) {
        new Create();
    }

}