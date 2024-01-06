package com.cars.locationcars.controller;

import com.cars.locationcars.entities.transmission;
import com.cars.locationcars.service.TransmissionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class transmissionController {

        private TransmissionService transmissionService;

        @GetMapping("/transmissions")
        public String AllTran(Model m,
                                 @RequestParam(name="mc",defaultValue ="")String mc,
                                 @RequestParam(name = "page",defaultValue = "0")int page,
                                 @RequestParam(name = "size",defaultValue = "5")int size) {
            Page<transmission> list = transmissionService.getTransmissionByMC(mc, PageRequest.of(page, size));
            m.addAttribute("transmissions",list.getContent());
            m.addAttribute("pages",new  int[list.getTotalPages()]);
            m.addAttribute("current",list.getNumber());
            m.addAttribute("mc", mc);
            return "transmissions";
        }

        @GetMapping("/formajouTran")
        public String form(Model m){
            transmission t= new transmission();
            m.addAttribute("transmission",t);
            return "addTran";
        }
        @PostMapping("/submitFormTran")
        public String create(@ModelAttribute("transmission") transmission transmission){
            transmissionService.saveTransmission(transmission);
            return "redirect:/transmissions";
        }
        @GetMapping("/deleteTran/{id}")
        public String delete(@PathVariable Long id){
            transmissionService.deleteTransmission(id);
            return "redirect:/transmissions";
        }

        @GetMapping("/updateTran/{id}")
        public String updateTran(@PathVariable Long id,Model m)
        {
            transmission t= transmissionService.getTransmissionBId(id);
            m.addAttribute("transmission",t);
            return "addTran";
        }




}
