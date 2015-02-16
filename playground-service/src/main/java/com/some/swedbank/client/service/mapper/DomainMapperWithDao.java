package com.some.swedbank.client.service.mapper;

import com.some.swedbank.client.dao.entity.DaoEntity;
import com.some.swedbank.client.service.entity.DomainEntity;

public interface DomainMapperWithDao {
	DomainEntity createDomainFromDao(DaoEntity dao);
}
