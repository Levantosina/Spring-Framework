package org.example.stations.StationsApp.repositories;

import org.example.stations.StationsApp.models.stationMay;

import java.util.List;

/**
 * @author Levantosina
 */
public interface StationsProjections {

    String getDepartureStationName();
    String getDepartureStationId();
    String getDeparture();
    String getReturnTime();
    String getDuration();
}
