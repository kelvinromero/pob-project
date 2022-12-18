package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person {
	
    private String name;
    @Id
    private String document;
    @ElementCollection
    private List<String> phone = new ArrayList<>();
    @Version
    private long version;
	
	public Person() {
	}

	public Person(String name, String document, String phone) {
		this.name = name;
		this.document = document;
		this.phone.add(phone);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public List<String> getPhone() {
		return phone;
	}

	public void addPhone(String phone) {
		this.phone.add(phone);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", document=" + document + ", phone=" + phone + "]";
	}
	
}
