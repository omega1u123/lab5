package org.example.lab5.service;

import org.example.lab5.model.AdvertisementEntity;
import org.example.lab5.model.AdvertisementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepo advertisementRepo;

    public List<AdvertisementEntity> getAllAdvertisement(){
        return advertisementRepo.findAll();
    }

    public AdvertisementEntity createAdvertisement(AdvertisementEntity ad){
        return advertisementRepo.save(ad);
    }

    public AdvertisementEntity getAdvertisementById(int id){
        return advertisementRepo.findById(id).orElseThrow();
    }

    public void addView(int id){
        var advertisement = advertisementRepo.findById(id).get();
        advertisement.setViews(advertisement.getViews() + 1);
        advertisementRepo.save(advertisement);
    }

}
