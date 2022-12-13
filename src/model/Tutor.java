package model;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tutor extends Person {
    private List<Pet> pets = new ArrayList<Pet>();

    public Tutor() {
    }

    public Tutor(String name, String document, String phone) {
        super(name, document, phone);
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public List<Pet> getPets() {
        return pets;
    }
    
    @Override
    public String toString() {
        return "Tutor [name=" + getName() + ", document=" + getDocument() + ", phone=" + getPhone() + ", pets=" + pets + "]";
    }
}
