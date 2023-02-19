package org.example.stations.StationsApp.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * @author Levantosina
 */
@Entity
@Table(name = "may2021")

public class stationMay {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "departure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departure;

    @Column(name = "return")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnN;
    @Column(name = "departure_station_id")
    private Integer departureStationId;

    @Column(name = "departure_station_name")
    private String departureStationName;

    @Column(name = "return_station_name")
    private String returnStationName;
    @Column(name = "return_station_id")
    private Integer returnStationId;

    @Column(name = "covered_distance")
    private Double coveredDistance;

    @Column(name = "duration")
    private Integer duration;

    public stationMay() {

    }

    public stationMay(Integer id, Date departure, Date returnN, Integer departureStationId, String departureStationName, String returnStationName, Integer returnStationId, Double coveredDistance, Integer duration) {
        this.id = id;
        this.departure = departure;
        this.returnN = returnN;
        this.departureStationId = departureStationId;
        this.departureStationName = departureStationName;
        this.returnStationName = returnStationName;
        this.returnStationId = returnStationId;
        this.coveredDistance = coveredDistance;
        this.duration = duration;
    }

    public stationMay(String departureStationName){

        this.departureStationName=departureStationName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getReturnN() {
        return returnN;
    }

    public void setReturnN(Date returnN) {
        this.returnN = returnN;
    }

    public Integer getDepartureStationId() {
        return departureStationId;
    }

    public void setDepartureStationId(Integer departureStationId) {
        this.departureStationId = departureStationId;
    }

    public String getDepartureStationName() {
        return departureStationName;
    }

    public void setDepartureStationName(String departureStationName) {
        this.departureStationName = departureStationName;
    }

    public String getReturnStationName() {
        return returnStationName;
    }

    public void setReturnStationName(String returnStationName) {
        this.returnStationName = returnStationName;
    }

    public Double getCoveredDistance() {
        return coveredDistance;
    }

    public void setCoveredDistance(Double coveredDistance) {
        this.coveredDistance = coveredDistance;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }


    public Integer getReturnStationId() {
        return returnStationId;
    }

    public void setReturnStationId(Integer returnStationId) {
        this.returnStationId = returnStationId;
    }

    @Override
    public String toString() {
        return "stationMay{" +
                "id=" + id +
                ", departureStationName='" + departureStationName + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        stationMay that = (stationMay) o;
        return Objects.equals(departureStationName, that.departureStationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureStationName);
    }
}
