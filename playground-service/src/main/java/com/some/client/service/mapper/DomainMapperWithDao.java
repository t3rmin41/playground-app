package com.some.client.service.mapper;

import com.some.client.dao.entity.DaoEntity;
import com.some.client.service.entity.DomainEntity;

public interface DomainMapperWithDao {
	DomainEntity createDomainFromDao(DaoEntity dao);
}
