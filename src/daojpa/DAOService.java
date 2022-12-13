package daojpa;

// import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Service;

public class DAOService extends DAO<Service>{

	public Service read(Object name) {
		try {
			TypedQuery<Service> q = manager.createQuery(""
					+ "select s from Service s where s.name = :name"
					+ "", Service.class);
			q.setParameter("name", name);
			
			return q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

}
