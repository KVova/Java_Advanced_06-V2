package volodymyr.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import volodymyr.domain.User;

public class UserMapper {

	public static User map(ResultSet result) throws SQLException {
		
		String firstName = result.getString("first_name");
		String lastName = result.getString("last_name");
		int age = result.getInt("age");
		String address = result.getString("address");
		String userEmail = result.getString("user_email");
		String password = result.getString("password");
		
		return new User(firstName, lastName, age, address, userEmail, password);
	}
	
}
