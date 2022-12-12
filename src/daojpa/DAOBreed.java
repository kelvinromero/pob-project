package daojpa;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Breed;

public class DAOBreed extends DAO<Breed>{

	public Breed read(Object id) {
		try {
			TypedQuery<Breed> q = manager.createQuery(""
					+ "select b from breed where id = :n"
					+ "", Breed.class);
			q.setParameter("n", id);
			
			return q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

}
