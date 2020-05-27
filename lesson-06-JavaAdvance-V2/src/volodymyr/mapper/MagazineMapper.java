package volodymyr.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import volodymyr.domain.Magazine;

public class MagazineMapper {

	public static Magazine map(ResultSet result) throws SQLException {
		
		String magazineName = result.getString("magazine_name");
		Double magazinePrice = result.getDouble("magazine_price");
		int quantity = result.getInt("quantity");
		
		return new Magazine(magazineName, magazinePrice, quantity);
	}
	
}
