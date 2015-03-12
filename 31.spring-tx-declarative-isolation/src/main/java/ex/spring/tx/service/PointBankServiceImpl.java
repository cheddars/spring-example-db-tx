package ex.spring.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.spring.tx.dao.PointBankDao;

@Service
public class PointBankServiceImpl implements PointBankService {
	@Autowired private PointBankDao pointBankDao;
	
	@Override
	public void update(int amount) {
		pointBankDao.update(amount);
	}

}
