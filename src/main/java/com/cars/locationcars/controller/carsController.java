package com.cars.locationcars.controller;

import com.cars.locationcars.entities.Car;
import com.cars.locationcars.service.ICarsService;
import com.cars.locationcars.service.TransmissionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Controller
@AllArgsConstructor

public class carsController {
    private ICarsService carsService;
    private TransmissionService transmissionService;

    @GetMapping("/index")
    public String getAllProducts(Model m,
                                 @RequestParam(name = "mc",defaultValue ="" ) String mc,
                                 @RequestParam(name="page",defaultValue = "0")int page,
                                 @RequestParam(name="size",defaultValue = "6")int size)
    {
        //List<Produit> liste=serviceProduit.getAllProducts();
        Page<Car> liste= carsService.getCarsByMc(mc, PageRequest.of(page,size));
        m.addAttribute("mc",mc);
        m.addAttribute("cars",liste.getContent());
        m.addAttribute("currentpage",page);
        m.addAttribute("pages",new int[liste.getTotalPages()]);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") Long idProduit)
    {
        carsService.deleteCar(idProduit);
        return "redirect:/index";
    }

    @GetMapping("/formCar")
    public String formAjout(Model m)
    {
        m.addAttribute("transmission",transmissionService.getAllTransmissions());
        m.addAttribute("car",new Car());
        return "addCar";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute Car p) throws IOException {
        carsService.saveCar(p);
        return "redirect:/index";
    }
    @GetMapping("/update/{id}")
    public String updateCar(@PathVariable Long id,Model m)
    {
        Car p= carsService.getCarById(id);
        m.addAttribute("car",p);
        m.addAttribute("transmission",transmissionService.getAllTransmissions());
        return "addCar";
    }
}
