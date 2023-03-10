package org.example.stations.StationsApp.repositories;


import org.example.stations.StationsApp.models.stationMay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Levantosina
 */
@Repository
public interface StationsRepository extends JpaRepository<stationMay, Integer> {


    @Query(value = "select   p from stationMay p  where p.duration > 10 AND p.coveredDistance>10" )
    Page<stationMay> findstationMayByPage(Pageable pageable);

//    @Query(value = "select distinct new org.example.stations.StationsApp.models.stationMay (stationmay0_.departureStationName)  from stationMay stationmay0_",
//               countQuery = "select count(distinct stationmay0_.departureStationName)  from stationMay stationmay0_", nativeQuery = false)
    @Query(value = "select distinct new org.example.stations.StationsApp.models.stationMay (stationmay0_.departureStationName)  from stationMay stationmay0_",
               countQuery = "select count(distinct stationmay0_.departureStationName)  from stationMay stationmay0_", nativeQuery = false)

    Page<StationsProjections> findDistinctDepartureStationName(Pageable pageable);


    @Query(value = "SELECT  new org.example.stations.StationsApp.models.stationMay (m.departure,m.returnStationName,m.returnTime,m.coveredDistance,m.duration) FROM stationMay m  WHERE m.duration > 10 AND m.coveredDistance>10 AND m.departureStationName = ?1 ",nativeQuery = false)
    Page<stationMay> oneTest(String departureStationId,Pageable pageable);



}





