package daojpa;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Employee;

public class DAOEmployee extends DAO<Employee>{

	public Employee read(Object document) {
		try {
			TypedQuery<Employee> q = manager.createQuery(""
					+ "select e from Employee e where e.document = :document"
					+ "", Employee.class);
			q.setParameter("document", document);
			
			return q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

	public List<Employee> queryEmployeesWithoutServiceOrder() {
		try {
			TypedQuery<Employee> q = manager.createQuery(""
					+ "select e from Employee e where SIZE(e.serviceOrders) = 0"
					+ "", Employee.class);
			
			return q.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}

}
