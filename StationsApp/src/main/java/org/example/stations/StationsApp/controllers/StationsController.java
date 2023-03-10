package org.example.stations.StationsApp.controllers;


import org.example.stations.StationsApp.models.stationMay;
import org.example.stations.StationsApp.repositories.StationsProjections;
import org.example.stations.StationsApp.repositories.StationsRepository;
import org.example.stations.StationsApp.services.StationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Levantosina
 */
@Controller
@RequestMapping("/stations")
public class StationsController {



    private final StationsService stationsService;
    @Autowired
    public StationsController(StationsService stationsService, StationsRepository stationMayRepository) {
        this.stationsService = stationsService;
    }
    @GetMapping("/page/{pageNumber}")
    public String getOnePage(Model model,@PathVariable("pageNumber") int currentPage) {
        Page<stationMay> page = stationsService.findstationMayByPage(currentPage);

        long totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<stationMay> stations = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("station", stations);
        return "stations/index";
    }
    @GetMapping("/show/page/{pageNumber1}")
    public String getListSt(Model model,@PathVariable("pageNumber1") int currentPage1) {
        Page<StationsProjections> stationPage = stationsService.getListOfStations(currentPage1);
        List<StationsProjections> stations = stationPage.getContent();

        long totalPages1 = stationPage.getTotalPages();
        long totalItems1 = stationPage.getTotalElements();

        model.addAttribute("totalPages1", totalPages1);
        model.addAttribute("totalItems1", totalItems1);
        model.addAttribute("currentPage1", currentPage1);
        model.addAttribute("station", stations);
        return "stations/show";
    }

    @GetMapping("/show/page/{currentPage}/{id}")
    public String test(Model model,@PathVariable("id") String id,@PathVariable("currentPage") int currentPage){

        Page<stationMay>list = stationsService.findTest(id);
        List<stationMay>list1= list.getContent();

        long pages= list.getTotalPages();
        long items = list.getTotalElements();

        model.addAttribute("totalItems3", items);
        model.addAttribute("totalPages3", pages);
        model.addAttribute("currentPage3", currentPage);
        model.addAttribute( "stationMay",list1);
        return "stations/showStation";
    }
    @GetMapping
    public String index(Model model){

        return getOnePage(model,1);
    }

    @GetMapping ("/new")
    public String newStation(Model model){
        model.addAttribute("stationMay",new stationMay());
        return "stations/new";
    }

    @PostMapping
    public String create(@ModelAttribute("stationMay") stationMay stationMay,
                         BindingResult bindingResult) {;

            if (bindingResult.hasErrors())
                return "stations/new";

            stationsService.save(stationMay);
            return "redirect:/people";

    }
}


















