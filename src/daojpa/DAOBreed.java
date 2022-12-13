package daojpa;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Breed;

public class DAOBreed extends DAO<Breed>{

	public Breed read(Object name) {
		try {
			TypedQuery<Breed> q = manager.createQuery("" +
					"select b from Breed b where b.name = :name" +
					"", Breed.class);
			q.setParameter("name", name);
			
			return q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

}
