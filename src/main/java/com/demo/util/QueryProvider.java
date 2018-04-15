package com.demo.util;

public class QueryProvider {

	public static final String GET_ALL_EMPLOYEES = "SELECT * FROM employee";

	public static final String GET_EMPLOYEE = "SELECT * FROM employee WHERE id=:empId";

	public static final String INSERT_EMPLOYEE = "INSERT INTO employee (firstName, lastName, email, phone, street, area, city, state, country, zip) "
			+ "VALUES (:firstName, :lastName, :email, :phone, :street, :area, :city, :state, :country, :zip)";

	public static final String UPDATE_EMPLOYEE = "UPDATE employee set firstName=:firstName, lastName=:lastName, email=:email, phone=:phone, street=:street,"
			+ " area=:area, city=:city, state=:state, country=:country, zip=:zip WHERE id=:id";

	public static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id=:id";

}
