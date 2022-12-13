package daojpa;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Pet;

public class DAOPet extends DAO<Pet>{

	public Pet read(Object name) {
		try {
			TypedQuery<Pet> q = manager.createQuery(""
					+ "select p from Pet p where p.name = :name"
					+ "", Pet.class);
			q.setParameter("name", name);
			
			return q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

}
