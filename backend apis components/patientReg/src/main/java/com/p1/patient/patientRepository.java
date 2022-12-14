package com.p1.patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface patientRepository extends JpaRepository<patient, Long>{
	
	void delete(patient patient);
	
	@Query("select p from patient p where status ='active'")
	List findAll();
	
	@Query("select p from patient p where status ='active'")
	patient findById(int id);
	
	patient save(patient patient);
	
	@Transactional
	@Modifying
	@Query("update patient p set p.status='Deactive' where id = ?1 ")
	int setPatientInfoById(int id);
	
}
