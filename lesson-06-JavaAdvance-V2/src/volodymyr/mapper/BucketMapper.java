package volodymyr.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import volodymyr.domain.Bucket;

public class BucketMapper {

	public static Bucket map(ResultSet result) throws SQLException {

		Integer bucketId = result.getInt("id");
		Integer userId = result.getInt("user_id");
		Integer magazineId = result.getInt("magazine_id");
		java.util.Date date = result.getDate("date");

		return new Bucket(bucketId, userId, magazineId, date);
	}

}
