package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tutor extends Person {
    @OneToMany(
            mappedBy = "tutor",
            cascade = CascadeType.ALL
    )
    private List<Pet> pets;
    @Version
    private long version;
    
    public Tutor() {
    }

    public Tutor(String name, String document, String phone) {
        super(name, document, phone);
        this.pets = new ArrayList<Pet>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void unbindPets() {
        this.pets = null;
    }
    
    @Override
    public String toString() {
        return "Tutor [name=" + getName() + ", document=" + getDocument() + ", phone=" + getPhone() + ", pets=" + pets + "]";
    }
}
