package org.woehlke.greenshop.customer;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.woehlke.greenshop.customer.entities.AddressBook;
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.entities.Customer;
import org.woehlke.greenshop.customer.model.CreateNewCustomerFormBean;

public interface CustomerService extends UserDetailsService {
	
	List<Country> findAllCountriesOrderByName();

	void createNewCustomer(CreateNewCustomerFormBean createNewCustomerFormBean);

	Customer findCustomerByEmail(String string);

	void deleteCustomer(Customer c);

	void updateCustomer(Customer customer);

	List<AddressBook> findAddressBookForCustomer(Customer customer);

	AddressBook findAddressById(long addressId);

	Country findCountryById(long countryId);

	void updateAddressBook(AddressBook persistentAddress);

	void deleteAddress(AddressBook customersAddress);

	void addAddress(AddressBook transientAddress);
}
