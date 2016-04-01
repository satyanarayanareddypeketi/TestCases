package com.netenrich;
import static org.junit.Assert.*;
import org.junit.Test;
public class BasicTests {
	DatabaseDetails main = new DatabaseDetails();
	public String database_url = main.Databaseurl();
	public String database_username = main.Databaseusername();
	public String database_password = main.Databasepassword();
	@Test
	public void Databasetest(){
		Databaseconnection db_connection = new Databaseconnection(database_username,database_password,database_url);
		java.sql.Connection connection = db_connection.Access_Database();
		assertNotNull(connection);
	}
	@Test
	public void bothgivencorrect(){
		Login n=new Login("1","1");
		assertEquals("You are logged in.",n.validate());
	}
	@Test
	public void bothgivenwrong(){
		Login n=new Login("username","password");
		assertEquals("You are logged in.",n.validate());
	}
	@Test
	public void bothareOmitted(){
		Login n=new Login("","");
		assertEquals("Login Failed.",n.validate());
		
	}
}
