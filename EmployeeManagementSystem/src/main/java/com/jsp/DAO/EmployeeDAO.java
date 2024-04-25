package com.jsp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.DTO.EmployeeDTO;

@Repository
public class EmployeeDAO {
	
	
	@Autowired
	EntityManager manager;
	
	
	@Autowired
	EntityTransaction transaction;
	
	
	public void saveEmployee(EmployeeDTO employee)
	{
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}
	
	//to find employee based on id
	public EmployeeDTO getEmployeeById(int id)
	{
		EmployeeDTO e = manager.find(EmployeeDTO.class, id);
		return e;
		
	}
	
	//to delete employee details
	public void deleteEmployee(int id)
	{
		EmployeeDTO e = manager.find(EmployeeDTO.class, id);
		if(e != null)
		{
			transaction.begin();
			manager.remove(e);
			transaction.commit();
		}
		
	}
	
	//to update employee details
	public void updateEmployee(EmployeeDTO updateEmployee)
	{
		transaction.begin();
		manager.merge(updateEmployee);
		transaction.commit();
	}
	
	//to get allEmployee details
		public List<EmployeeDTO> getAllEmployee()
		{
			Query q = manager.createQuery("select e from EmployeeDTO e");
			List<EmployeeDTO> employees = q.getResultList();
			return employees;
		}
	

	
	
}
