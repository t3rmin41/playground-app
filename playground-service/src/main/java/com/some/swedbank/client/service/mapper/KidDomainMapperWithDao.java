package com.some.swedbank.client.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.some.swedbank.client.dao.entity.DaoEntity;
import com.some.swedbank.client.dao.entity.KidDao;
import com.some.swedbank.client.dao.repository.KidRepository;
import com.some.swedbank.client.service.entity.DomainEntity;
import com.some.swedbank.client.service.entity.person.Kid;

@Service("kidMapper")
public class KidDomainMapperWithDao implements DomainMapperWithDao {

	@Autowired
	private KidRepository kidRepository;
	
	@Override
	public DomainEntity createDomainFromDao(DaoEntity dao) {
		return null;
	}
	
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

}