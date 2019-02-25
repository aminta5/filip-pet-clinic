package com.agartha.filippetclinic.controllers;


import com.agartha.filippetclinic.model.Owner;
import com.agartha.filippetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /*@RequestMapping({"/owners"})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }*/

    @RequestMapping("/owners/find")
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping("/owners/owners")
    public String processFindForm(Owner owner, BindingResult result, Model model){
        //allow parametarless GET request for /onwers to return al records
        if(owner.getLastName() == null){
            owner.setLastName(""); // this empty string signifies broadest possibile search
        }

        //find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if(results.isEmpty()){
            //no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }
        else if(results.size() == 1){
            //1 owner found
            owner = results.iterator().next();
            return "redirect:/owners/" + owner.getId();
        }
        else{
            //multiple users found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/owners/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long id){
        ModelAndView mov = new ModelAndView("owners/ownerDetails");
        mov.addObject(ownerService.findById(id));
        return mov;
    }
}
