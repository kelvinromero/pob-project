package daojpa;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.ServiceOrder;

public class DAOServiceOrder extends DAO<ServiceOrder>{

	public ServiceOrder read(Object id) {
		try {
			TypedQuery<ServiceOrder> q = manager.createQuery(""
					+ "select s from ServiceOrder s where s.id = :id"
					+ "", ServiceOrder.class);
			q.setParameter("id", id);
			
			return q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

}
