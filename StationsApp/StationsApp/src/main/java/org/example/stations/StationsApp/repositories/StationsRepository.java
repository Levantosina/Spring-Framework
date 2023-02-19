package org.example.stations.StationsApp.repositories;


import org.example.stations.StationsApp.models.stationMay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author Levantosina
 */
@Repository
public interface StationsRepository extends JpaRepository<stationMay,Integer> {
//@Query(value = "select p from stationMay p where p.departureStationName =?1")
    @Query(value = "select   p from stationMay p  where p.duration > 10 AND p.coveredDistance>10 AND p.id>=1" )
    Page<stationMay> findstationMayByPage(Pageable pageable);


    @Query(value = "select  p from stationMay p")
    Page<stationMay>findListOfStations(Pageable pageable);


    @Query(value = "select p from stationMay p where p.id>=1")
    Page<StationProjection>getStationMayByDepartureStationName(Pageable pageable);





}
