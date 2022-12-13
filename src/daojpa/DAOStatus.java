package daojpa;

// import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Status;

public class DAOStatus extends DAO<Status>{

	public Status read(Object name) {
		try {
			TypedQuery<Status> q = manager.createQuery(""
					+ "select s from Status s where s.name = :name"
					+ "", Status.class);
			q.setParameter("name", name);
			
			return q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

}
