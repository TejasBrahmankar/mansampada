package com.tableslearnedmapping.entitymapping.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;


import com.tableslearnedmapping.entitymapping.entities.Relative;

public interface Relativerepo extends JpaRepository<Relative, Integer> {

	@Query("from Relative as c where c.user.userId=:userId")
	public Set<Relative> findRelativesByUser(@RequestParam("userId")int userId);
	
	public void deleteByRelativeId(Integer relativeId);
}
