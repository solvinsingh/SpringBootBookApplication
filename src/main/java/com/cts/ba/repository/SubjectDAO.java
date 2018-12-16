package com.cts.ba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.ba.model.Subject;

@Repository
public interface SubjectDAO extends CrudRepository<Subject,Long>{
	
	@Query(value="SELECT s FROM Subject s where s.durationInHours = :durationInHours")
	public List<Subject> findByDurationInHours(@Param("durationInHours") int durationInHours);


}
