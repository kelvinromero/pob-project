package daojpa;

import java.util.List;

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

	public List<ServiceOrder> queryServiceOrdersByStatus(Object statusName) {
		try {
			TypedQuery<ServiceOrder> q = manager.createQuery(""
					+ "select s from ServiceOrder s join s.status st where st.name = :x"
					+ "", ServiceOrder.class);
			q.setParameter("x", statusName);
			return q.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}

	public List<ServiceOrder> queryServiceOrdersByEmployeeAndStatus(Object employeeDocument, Object statusName) {
		try {
			TypedQuery<ServiceOrder> q = manager.createQuery(""
					+ "select s from ServiceOrder s join s.employee e join s.status st where e.document = :x and st.name = :y"
					+ "", ServiceOrder.class);
			q.setParameter("x", employeeDocument);
			q.setParameter("y", statusName);
			return q.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
}

// public List<ServiceOrder> queryServiceOrdersByServiceAndBreed(String service, String breed) {
// 	try {
// 		TypedQuery<ServiceOrder> q = manager.createQuery(""
// 				+ "select so from ServiceOrder so join so.services se where se.name = :x and so join so.pet p where p.breed.name = :y"
// 				+ "", ServiceOrder.class);
// 		q.setParameter("x", service);
// 		q.setParameter("y", breed);
// 		return q.getResultList();
// 	}catch(NoResultException e) {
// 		return null;
// 	}
// }