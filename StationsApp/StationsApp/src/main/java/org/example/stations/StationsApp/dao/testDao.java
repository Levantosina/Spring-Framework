package org.example.stations.StationsApp.dao;



import org.example.stations.StationsApp.models.stationMay;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Levantosina
 */
@Component
public class testDao {
    private final EntityManager entityManager;

    public testDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


  //  @Transactional(readOnly = true)
  //  public Set<stationMay> testStations(){
//        Session session=entityManager.unwrap(Session.class);
//
//        List<stationMay> stationMays=session.createQuery("select p from  stationMay p",stationMay.class).getResultList();
//
//        for (stationMay stationMay: stationMays) {
//            System.out.println(stationMay.getDepartureStationName());
 //       }

  //      Set<stationMay> stationMays=new HashSet<stationMay>(session.createQuery("select p from stationMay p").getResultList());

    //    for(stationMay stationMay:stationMays)
    //        System.out.println(stationMay.getDepartureStationName());
     //   return stationMays;
  //  }

}
