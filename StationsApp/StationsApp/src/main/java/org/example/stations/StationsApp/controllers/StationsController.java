package org.example.stations.StationsApp.controllers;


import org.example.stations.StationsApp.dao.testDao;
import org.example.stations.StationsApp.models.stationMay;
import org.example.stations.StationsApp.repositories.StationProjection;
import org.example.stations.StationsApp.services.StationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Levantosina
 */
@Controller
@RequestMapping("/stations")
public class StationsController {

private  final testDao testDao;
    private final StationsService stationsService;

    @Autowired
    public StationsController(testDao testDao, StationsService stationsService) {
        this.testDao = testDao;
        this.stationsService = stationsService;
    }

    @GetMapping("/page/{pageNumber}")
    public String getOnePage(Model model,@PathVariable("pageNumber") int currentPage) {
        Page<stationMay> page = stationsService.findstationMayByPage(currentPage);
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<stationMay> stations = page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("stations", stations);
        return "stations/index";
    }

    @GetMapping("/show/page/{pageNumber}")
    public String getListSt(Model model,@PathVariable("pageNumber") int currentPage) {
        Page<StationProjection> page = stationsService.getStationMayByDepartureStationName(currentPage);
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<StationProjection> stations = page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("stations", stations);
        return "stations/show";
    }
    @GetMapping
    public String index(Model model){

        return getOnePage(model,1);
    }

//    @GetMapping()
//    public String index(Model model) {
//       model.addAttribute("stations", stationsService.findAll());
//
//     // model.addAttribute("stations", testDao.testStations());
//        return "stations/index";
//    }

    @GetMapping("/{id}")
    public String show(Model model){

        return getListSt( model,1);
    }

//    @GetMapping("/laptops/name")
//    public ResponseEntity<List<stationMay>> findDepartureStationName(@RequestParam String findDepartureStationName) {
//        return new ResponseEntity<List<stationMay>>(StationsRepository.findDepartureStationName(findDepartureStationName), HttpStatus.OK);
//    }

}
