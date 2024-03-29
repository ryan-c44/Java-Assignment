package assignment2;

import java.util.ArrayList;

public class Customer extends Billing {
	
	private Address customerAddress;

	public Customer(String id, String firstName, String lastName, String username, String password, UserType userType, PermissionType permission,
					boolean status, Address billingAddress, String email, Address customerAddress) {
		super(id, firstName, lastName, username, password, userType, permission, status, billingAddress, email);
		
		this.customerAddress = customerAddress;
		
	}
	
	public Customer(String id, String firstName, String lastName, String username, String password, boolean status, Address billingAddress, String email, Address customerAddress) {
		this(id, firstName, lastName, username, password, UserType.Customer, PermissionType.Booking, status, billingAddress, email, customerAddress);
	}
	
	public Customer(String id, String firstName, String lastName, String username, String password, UserType userType, boolean status, String email) {
		this(id, firstName, lastName, username, password, userType, PermissionType.Booking, status, new Address(), email, new Address());
	}
	
	@Override
	protected void setId(String id) throws Exception {
		super.setId(id);
		
		if(!id.startsWith("1") || id.length() != 6 || !id.startsWith("1") && id.length() != 6 ) {
			throw new Exception();
	    }
	}
	
	@Override
	public void setPermission(PermissionType permission) throws Exception {
		
		if(!(permission.equals(PermissionType.Booking)) || !(permission.equals(PermissionType.None)) || !(permission.equals(PermissionType.Booking)) && !(permission.equals(PermissionType.None))) {
			throw new Exception();
		} else {
			super.setPermission(permission);
		}
	}
	
	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public static ArrayList<Customer> filterOnlyCustomerList(ArrayList<User> users) {
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		for(User user : users) {
			if(user.getUserType().equals(UserType.Customer)) {
				customers.add((Customer) user);
			}
		}
		return customers;
	}
	
	public static ArrayList<Customer> filterOnlyVIPCustomerList(ArrayList<User> users) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		for(User user : users) {
			if(user.getUserType() == UserType.VIP) {
				customers.add((Customer) user);
			}
		}
		return customers;
	}
	
	

}
