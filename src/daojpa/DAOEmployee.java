package daojpa;

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

}
