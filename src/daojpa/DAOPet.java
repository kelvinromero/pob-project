package daojpa;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Pet;

public class DAOPet extends DAO<Pet>{

	public Pet read(Object id) {
		try {
			TypedQuery<Pet> q = manager.createQuery(""
					+ "select p from Pet p where p.id = :id"
					+ "", Pet.class);
			q.setParameter("id", id);
			
			return q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

}
