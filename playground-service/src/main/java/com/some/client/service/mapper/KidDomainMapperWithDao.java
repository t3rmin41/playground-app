package com.some.client.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.some.client.dao.entity.DaoEntity;
import com.some.client.dao.entity.KidDao;
import com.some.client.dao.repository.KidRepository;
import com.some.client.service.entity.DomainEntity;
import com.some.client.service.entity.person.Kid;

@Service("kidMapper")
public class KidDomainMapperWithDao implements DomainMapperWithDao {

	@Autowired
	private KidRepository kidRepository;
	
	@Override
	public DomainEntity createDomainFromDao(DaoEntity dao) {
		return getKidById(dao.getId());
	}
	
	//@Transactional
	public List<Kid> getAllKids() {
		List<KidDao> daoKidList = kidRepository.getAllKids();
		List<Kid> domainKidList = new ArrayList<Kid>();
		for (KidDao kidDao : daoKidList) {
			domainKidList.add(new Kid(
									  kidDao.getId(),
									  kidDao.getName(),
									  kidDao.getAge(), 
									  kidDao.getTicketNumber(),
									  kidDao.isWaitingAccepted()
									 )
							  );
		}
		return domainKidList;
	}
	
	public Kid getKidById(Long id) {
		KidDao kidDao = kidRepository.getKidById(id);
		return kidDao != null ? new Kid(kidDao.getId(), kidDao.getName(), kidDao.getAge(), kidDao.getTicketNumber(), kidDao.isWaitingAccepted()) :  null;
	}

}