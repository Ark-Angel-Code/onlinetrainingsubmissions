package com.spring.rest.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.spring.entity.AdvertisementEntity;

@Component
public interface AdvertisementRepository extends JpaRepository<AdvertisementEntity, Long> 
{
	List<AdvertisementEntity> findByName(String name);
	AdvertisementEntity findByPostid(String postid);
	void deleteByPostid(String postid);
	List<AdvertisementEntity> findBySearchText(String searchText);
	List<AdvertisementEntity> findByCategory(String category);
	List<AdvertisementEntity> findByDate(LocalDate Date);
	List<AdvertisementEntity> findByDateGreaterThanEqual(LocalDate date);
	List<AdvertisementEntity> findByDateLessThanEqual(LocalDate date);
	List<AdvertisementEntity> findByDateGreaterThanEqualAndDateLessThanEqual(LocalDate startDate, LocalDate endDate);
	List<AdvertisementEntity> findByOrderByTitleAsc();
	List<AdvertisementEntity> findByOrderByTitleDesc();
	List<AdvertisementEntity> findByOrderByPostidAsc();
	List<AdvertisementEntity> findByOrderByPostidDesc();
	List<AdvertisementEntity> findByOrderByNameAsc();
	List<AdvertisementEntity> findByOrderByNameDesc();


}
