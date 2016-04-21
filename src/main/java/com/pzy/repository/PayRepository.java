package com.pzy.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.Pay;
import com.pzy.entity.User;
public interface PayRepository extends PagingAndSortingRepository<Pay, Long>,JpaSpecificationExecutor<Pay>{
	public List<Pay> findByUser(User user);
}

