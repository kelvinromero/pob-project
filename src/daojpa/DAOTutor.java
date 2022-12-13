package daojpa;

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

}
