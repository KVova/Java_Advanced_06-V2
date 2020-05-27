package volodymyr.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import volodymyr.dao.MagazineDao;
import volodymyr.dao.impl.MagazineDaoImpl;
import volodymyr.domain.Magazine;
import volodymyr.service.MagazineService;

public class MagazineServiceImpl implements MagazineService {

	public static MagazineService getMagazineService() {
		if (magazineServiceImpl == null) {
			magazineServiceImpl = new MagazineServiceImpl();
		}
		return magazineServiceImpl;
	}

	@Override
	public Magazine create(Magazine t) {
		return magazineDao.create(t);
	}

	@Override
	public Magazine read(Integer id) {
		return magazineDao.read(id);
	}

	@Override
	public Magazine update(Magazine t) {
		return magazineDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		magazineDao.delete(id);
	}

	@Override
	public List<Magazine> readAll() {
		return magazineDao.readAll();
	}

	private static MagazineServiceImpl magazineServiceImpl;

	private static Logger LOGGER = Logger.getLogger(MagazineServiceImpl.class);

	private MagazineDao magazineDao;
	
	private MagazineServiceImpl() {

		try {
			magazineDao = new MagazineDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

}
