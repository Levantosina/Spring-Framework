package org.example.stations.StationsApp.services;


import org.example.stations.StationsApp.models.stationMay;
import org.example.stations.StationsApp.repositories.StationsProjections;
import org.example.stations.StationsApp.repositories.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Levantosina
 */

@Service
@Transactional(readOnly = true)
public class StationsService {

    private static final int PAGE_SIZE = 30;
    private static final int DEFAULT_PAGE = 1;

    private final StationsRepository stationsRepository;

    @Autowired
    public StationsService(StationsRepository stationsRepository) {
        super();
        this.stationsRepository = stationsRepository;
    }


    public Page<stationMay> findstationMayByPage(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, PAGE_SIZE);
        return stationsRepository.findstationMayByPage(pageable);


    }

    public Page<StationsProjections> getListOfStations(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum - 1, PAGE_SIZE);
        return stationsRepository.findDistinctDepartureStationName(pageable);
    }

    public Page<stationMay> findTest(String id) {
        Pageable pageable = PageRequest.of(DEFAULT_PAGE, PAGE_SIZE);
        return stationsRepository.oneTest(id, pageable).map(stations -> {
//            String departure = String.valueOf(stations.getDeparture());
//            String cd = String.valueOf(stations.getReturnTime());
          return stations;
        });
    }
    @Transactional
    public void save(stationMay stationMay) {

        stationsRepository.save(stationMay);
    }


}



