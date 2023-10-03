package com.notifier.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.notifier.model.BirthdayDetails;

@EnableJpaRepositories
public interface BirthdayRepository extends JpaRepository<BirthdayDetails, Integer> {
	
	
//	@Query("SELECT b FROM BirthdayDetails b WHERE b.enable='true'")
//	List<BirthdayDetails> findByEnable();
	
	
	@Query("SELECT u FROM bday u WHERE DATE_FORMAT(u.bdayDate,'%m-%d') = Date_FORMAT(CURRENT_DATE(),'%m-%d') AND (u.enable=false)")
	List<BirthdayDetails> findAllBirthday();

	
	
	@Query("SELECT u FROM bday u WHERE u.name LIKE :name%")
	List<BirthdayDetails> findAllByName(@Param("name") String name);

	@Transactional
	@Modifying
	@Query("UPDATE bday SET enable=true WHERE DATE_FORMAT(bdayDate,'%m-%d') = Date_FORMAT(CURRENT_DATE(),'%m-%d') AND (enable=false)")
	void findAllBdayBoy();
	
	@Transactional
	@Modifying
	@Query("UPDATE bday SET enable=false WHERE DATE_FORMAT(bdayDate,'%m-%d') != Date_FORMAT(CURRENT_DATE(),'%m-%d') AND (enable=true)")
	void resetBirthday();
	
}
