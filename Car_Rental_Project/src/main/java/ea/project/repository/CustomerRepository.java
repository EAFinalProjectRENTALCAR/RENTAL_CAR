package ea.project.repository;

import org.springframework.data.repository.CrudRepository;

import ea.project.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	public Customer findByusername(String username);

	 //public Customer findByUsernameAndPassword(String username, String password);

}
