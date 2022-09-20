package model;

import java.util.ArrayList;

public class Tutor extends Person {

    private ArrayList<Pet> pets;
    //public Person tutorPet;

    public Tutor(String name, String document, String phone) {
        super(name, document, phone);
        pets = new ArrayList<Pet>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }
    
    //public void setTutorPet(Person tutorDoPet) {
    	//this.tutorPet = tutorDoPet;
    //}
    @Override
    public String toString() {
        return "Tutor [name=" + getName() + ", document=" + getDocument() + ", phone=" + getPhone() + ", pets=" + pets + "]";
    }
}
