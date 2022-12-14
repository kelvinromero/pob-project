package model;

import jakarta.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	private Breed breed;
	private double weight;
	@ManyToOne(cascade = CascadeType.ALL)
	private Tutor tutor;
	
	public Pet(){
	}
	
	public Pet(String name, Breed breed, double weight, Tutor tutor) {
		super();
		this.name = name;
		this.breed = breed;
		this.weight = weight;
		this.tutor = tutor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Pet [name=" + name + ", breed=" + breed + ", weight=" + weight + "]";
	}
	
}
