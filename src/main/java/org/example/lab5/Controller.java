package org.example.lab5;

import org.example.lab5.model.AdvertisementEntity;
import org.example.lab5.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;


@org.springframework.stereotype.Controller
@RequestMapping("/advertisement")
public class Controller {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping("/mainPage")
    public String getAllAdvertisement(Model model){
        var advertisements = advertisementService.getAllAdvertisement();
        model.addAttribute("advertisements", advertisements);
        return "main_page";
    }

    @GetMapping("/mainPageFiltered")
    public String getAllAdvertisementFilteredByPrice(@RequestParam String filter, Model model){
        var advertisements = advertisementService.getAllAdvertisement();
        if ("low".equals(filter)) {
            advertisements = advertisements
                    .stream()
                    .sorted(Comparator.comparing(AdvertisementEntity::getPrice))
                    .toList();
        } else if ("high".equals(filter)) {
            advertisements = advertisements
                    .stream()
                    .sorted(Comparator.comparing(AdvertisementEntity::getPrice).reversed())
                    .toList();
        }
        model.addAttribute("advertisements", advertisements);
        return "main_page";
    }

    @GetMapping("/{id}")
    public String getAdvertisementById(@PathVariable("id") int id, Model model){
        var ad = advertisementService.getAdvertisementById(id);
        advertisementService.addView(id);
        model.addAttribute("advertisement", ad);
        return "advertisement";
    }

    @GetMapping("/add")
    public String addAdPage(){
        return "add_advertisement_page";
    }

    @PostMapping("/add")
    public String addAdvertisement(
            @RequestParam int price,
            @RequestParam int numberOfRooms,
            @RequestParam int numberOfBedrooms,
            @RequestParam int area,
            @RequestParam int floor,
            @RequestParam String region,
            @RequestParam String address
    ){
        var ad = advertisementService.createAdvertisement(new AdvertisementEntity(
           price,
           numberOfRooms,
           numberOfBedrooms,
           area,
           floor,
           region,
           address,
           0
        ));
        System.out.println(ad.getAddress());
        return "redirect:/advertisement/" + ad.getId();
    }

}
