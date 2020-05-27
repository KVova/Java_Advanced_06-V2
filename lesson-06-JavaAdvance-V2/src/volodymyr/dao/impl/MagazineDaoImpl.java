package volodymyr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import volodymyr.dao.MagazineDao;
import volodymyr.domain.Magazine;
import volodymyr.mapper.MagazineMapper;
import volodymyr.utils.ConnectionUtils;

public class MagazineDaoImpl implements MagazineDao {

	public MagazineDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Magazine create(Magazine magazine) {
		try {
			preparedStatemant = connection.prepareStatement(CREATE);
			preparedStatemant.setString(1, magazine.getMagazineName());
			preparedStatemant.setDouble(2, magazine.getMagazinePrice());
			preparedStatemant.setInt(3, magazine.getQuantity());
			preparedStatemant.executeUpdate();

			ResultSet rs = preparedStatemant.getGeneratedKeys();
			rs.next();
			magazine.setId(rs.getInt(1));

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return magazine;
	}

	@Override
	public Magazine read(Integer id) {
		Magazine product = null;
		try {
			preparedStatemant = connection.prepareStatement(READ_BY_ID);
			preparedStatemant.setInt(1, id);
			ResultSet result = preparedStatemant.executeQuery();
			result.next();

			return MagazineMapper.map(result);

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return product;
	}

	@Override
	public Magazine update(Magazine magazine) {
		try {
			preparedStatemant = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatemant.setString(1, magazine.getMagazineName());
			preparedStatemant.setDouble(2, magazine.getMagazinePrice());
			preparedStatemant.setInt(3, magazine.getQuantity());
			preparedStatemant.setInt(4, magazine.getId());
			preparedStatemant.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return magazine;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatemant = connection.prepareStatement(DELETE_BY_ID);
			preparedStatemant.setInt(1, id);
			preparedStatemant.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}

	}

	@Override
	public List<Magazine> readAll() {
		List<Magazine> listOfUser = new ArrayList<>();

		try {
			preparedStatemant = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatemant.executeQuery();
			while (result.next()) {
				listOfUser.add(MagazineMapper.map(result));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return listOfUser;
	}

	private static Logger LOGGER = Logger.getLogger(MagazineDaoImpl.class);

	private static String CREATE = "insert into magazine(magazine_name, magazine_price, quantity) value(?,?,?)";
	private static String READ_BY_ID = "select * from magazine where id =?";
	private static String UPDATE_BY_ID = "update magazine set magazine_name=?, magazine_price =?, quantity =? where id =?";
	private static String DELETE_BY_ID = "delete from magazine where id =?";
	private static String READ_ALL = "select * from magazine";

	private Connection connection;
	private PreparedStatement preparedStatemant;

}
