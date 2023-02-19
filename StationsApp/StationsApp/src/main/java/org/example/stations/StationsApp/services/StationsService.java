package org.example.stations.StationsApp.services;


import org.example.stations.StationsApp.models.stationMay;
import org.example.stations.StationsApp.repositories.StationProjection;
import org.example.stations.StationsApp.repositories.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Levantosina
 */

@Service
@Transactional(readOnly = true)
public class StationsService {

    private final StationsRepository stationsRepository;

    @Autowired
    public StationsService(StationsRepository stationsRepository) {
        super();
        this.stationsRepository = stationsRepository;
    }


    public Page<stationMay> findstationMayByPage(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 30);
        return stationsRepository.findstationMayByPage(pageable);


    }

    public Page<stationMay> findListOfStations(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 30);
        return stationsRepository.findListOfStations(pageable);
    }



    public Page<StationProjection>getStationMayByDepartureStationName(int pageNumber ){
        Pageable pageable = PageRequest.of(pageNumber - 1, 30);
        return  stationsRepository.getStationMayByDepartureStationName(pageable);

    }



}