package com.souza.charles.triathlete_sponsorship_web.controllers;

import com.souza.charles.triathlete_sponsorship_web.dtos.SponsorRequestDTO;
import com.souza.charles.triathlete_sponsorship_web.services.SponsorService;
import com.souza.charles.triathlete_sponsorship_web.utils.TriathleteSponsorshipMessages;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/sponsor")
public class SponsorController {

    @Autowired
    private SponsorService sponsorService;

    @GetMapping("/new")
    public String newSponsor(Model model) {
        model.addAttribute("newSponsor", new SponsorRequestDTO(null, null, List.of()));
        return "new-sponsor";
    }

    @PostMapping("/save")
    public String saveTriathlete(@ModelAttribute("newSponsor") @Valid SponsorRequestDTO dto, BindingResult errors,
                                 RedirectAttributes attributes) {
        if(errors.hasErrors()) {
            return "new-sponsor";
        }
        sponsorService.createSponsor(dto);
        attributes.addFlashAttribute("message", TriathleteSponsorshipMessages.SPONSOR_SAVED_SUCCESSFULLY);
        return "redirect:/sponsor/new";
    }
}
