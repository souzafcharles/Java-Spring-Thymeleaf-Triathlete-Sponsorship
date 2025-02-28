package com.souza.charles.triathlete_sponsorship_web.controllers;

import com.souza.charles.triathlete_sponsorship_web.exceptions.SponsorAlreadyExistsException; // Importe a exceção correta
import com.souza.charles.triathlete_sponsorship_web.models.Sponsor;
import com.souza.charles.triathlete_sponsorship_web.services.SponsorService;
import com.souza.charles.triathlete_sponsorship_web.utils.TriathleteSponsorshipMessages;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/sponsor")
public class SponsorController {

    @Autowired
    private SponsorService sponsorService;

    @GetMapping("/new")
    public String newSponsor(Model model) {
        Sponsor sponsor = new Sponsor();
        model.addAttribute("newSponsor", sponsor);
        return "/new-sponsor";
    }

    @PostMapping("/save")
    public String saveSponsor(@ModelAttribute("newSponsor") @Valid Sponsor sponsor,
                              BindingResult errors,
                              RedirectAttributes attributes,
                              Model model) {
        if (errors.hasErrors()) {
            return "/new-sponsor";
        }
        try {
            sponsorService.createSponsor(sponsor);
            attributes.addFlashAttribute("message", TriathleteSponsorshipMessages.SPONSOR_SAVED_SUCCESSFULLY);
            return "redirect:/sponsor/new";
        } catch (SponsorAlreadyExistsException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "/new-sponsor";
        }
    }
}