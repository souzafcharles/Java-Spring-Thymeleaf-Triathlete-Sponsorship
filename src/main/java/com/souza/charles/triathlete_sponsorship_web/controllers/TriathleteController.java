package com.souza.charles.triathlete_sponsorship_web.controllers;

import com.souza.charles.triathlete_sponsorship_web.exceptions.TriathleteNotFoundException;
import com.souza.charles.triathlete_sponsorship_web.models.Sponsor;
import com.souza.charles.triathlete_sponsorship_web.models.Triathlete;
import com.souza.charles.triathlete_sponsorship_web.services.SponsorService;
import com.souza.charles.triathlete_sponsorship_web.services.TriathleteService;
import com.souza.charles.triathlete_sponsorship_web.utils.TriathleteSponsorshipMessages;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class TriathleteController {

    @Autowired
    private TriathleteService triathleteService;

    @Autowired
    private SponsorService sponsorService;

    @GetMapping("/")
    public String listTriathletes(Model model) {
        List<Triathlete> triathletes = triathleteService.readAllTriathletes();
        model.addAttribute("listTriathletes", triathletes);
        return "/list-triathletes";
    }

    @PostMapping("/search")
    public String searchTriathletes(Model model, @Param("name") String name) {
        if (name == null) {
            return "redirect:/";
        }
        List<Triathlete> triathletes = triathleteService.readAllTriathletesByName(name);
        model.addAttribute("listTriathletes", triathletes);
        return "/list-triathletes";
    }

    @GetMapping("/new")
    public String newTriathlete(Model model) {
        Triathlete triathlete = new Triathlete();
        model.addAttribute("newTriathlete", triathlete);

        List<Sponsor> sponsors = sponsorService.readAllSponsors();
        model.addAttribute("listSponsors", sponsors);

        return "/new-triathlete";
    }

    @PostMapping("/save")
    public String saveTriathlete(Model model, @ModelAttribute("newTriathlete") @Valid Triathlete triathlete,
                                 BindingResult errors,
                                 RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            List<Sponsor> sponsors = sponsorService.readAllSponsors();
            model.addAttribute("listSponsors", sponsors);
            return "/new-triathlete";
        }
        triathleteService.createTriathlete(triathlete);
        attributes.addFlashAttribute("message", TriathleteSponsorshipMessages.TRIATHLETE_SAVED_SUCCESSFULLY);
        return "redirect:/new";
    }

    @GetMapping("/delete/{id}")
    public String deleteTriathlete(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            triathleteService.deleteTriathlete(id);
        } catch (TriathleteNotFoundException e) {
            attributes.addFlashAttribute("messageError", e.getMessage());
        }
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            Triathlete triathlete = triathleteService.readTriathleteById(id);
            model.addAttribute("objectTriathlete", triathlete);

            List<Sponsor> sponsors = sponsorService.readAllSponsors();
            model.addAttribute("listSponsors", sponsors);

            return "/edit-triathlete";
        } catch (TriathleteNotFoundException e) {
            attributes.addFlashAttribute("messageError", e.getMessage());
        }
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editTriathlete(Model model, @PathVariable("id") long id,
                                 @ModelAttribute("objectTriathlete") @Valid Triathlete triathlete,
                                 BindingResult errors) {
        if (errors.hasErrors()) {
            triathlete.setId(id);

            List<Sponsor> sponsors = sponsorService.readAllSponsors();
            model.addAttribute("listSponsors", sponsors);

            return "/edit-triathlete";
        }
        triathleteService.editTriathlete(triathlete);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String viewForm(Model model, @PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            Triathlete triathlete = triathleteService.readTriathleteById(id);
            model.addAttribute("objectTriathlete", triathlete);

            return "/view-triathlete";
        } catch (TriathleteNotFoundException e) {
            attributes.addFlashAttribute("messageError", e.getMessage());
        }
        return "redirect:/";
    }
}