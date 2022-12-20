package daojpa;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Tutor;

public class DAOTutor extends DAO<Tutor>{

	public Tutor read(Object document) {
		try {
			TypedQuery<Tutor> q = manager.createQuery(""
					+ "select t from Tutor t where t.document = :document"
					+ "", Tutor.class);
			q.setParameter("document", document);
			
			return q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

	public List<Tutor> queryTutorsWithMoreThanOnePet() {
		try {
			TypedQuery<Tutor> q = manager.createQuery(""
					+ "select t from Tutor t where SIZE(t.pets) > 1"
					+ "", Tutor.class);
			
			return q.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}

}