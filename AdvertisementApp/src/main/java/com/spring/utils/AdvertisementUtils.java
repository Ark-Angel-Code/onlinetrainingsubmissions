package com.spring.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.spring.entity.AdvertisementEntity;
import com.spring.json.Advertisement;

public class AdvertisementUtils {
	
	public static List<Advertisement> convertAdvertisementEntityListToAdvertisementList(List<AdvertisementEntity> advertisementEntityList) {
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();
		Consumer<AdvertisementEntity> consumer = (AdvertisementEntity advertisementEntity)->advertisementList.add(convertAdvertisementEntityToAdvertisement(advertisementEntity));
		advertisementEntityList.stream().forEach(consumer);
		return advertisementList;
	}
	
	public static Advertisement convertAdvertisementEntityToAdvertisement(AdvertisementEntity advertisementEntity) {
		return new Advertisement(advertisementEntity.getId(),advertisementEntity.getTitle(),advertisementEntity.getName(),advertisementEntity.getCategory(),
				advertisementEntity.getDescription(),advertisementEntity.getPostid(),
				advertisementEntity.getStatus(),advertisementEntity.getSearchText(),advertisementEntity.getDate());
	}

	public static AdvertisementEntity convertAdvertisementToAdvertisementEntity(Advertisement advertisement) {
		return new AdvertisementEntity(advertisement.getTitle(),advertisement.getName(),advertisement.getCategory(),advertisement.getDescription(),advertisement.getPostid(),
				advertisement.getStatus() ,advertisement.getSearchText(),advertisement.getDate());
	}
}
