package org.example.lab5.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepo extends CrudRepository<AdvertisementEntity, Integer> {

    List<AdvertisementEntity> findAll();

}
