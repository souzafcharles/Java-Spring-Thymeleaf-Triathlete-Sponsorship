package com.souza.charles.triathlete_sponsorship_web.controllers;

import com.souza.charles.triathlete_sponsorship_web.dtos.TriathleteRequestDTO;
import com.souza.charles.triathlete_sponsorship_web.dtos.TriathleteResponseDTO;
import com.souza.charles.triathlete_sponsorship_web.exceptions.TriathleteNotFoundException;
import com.souza.charles.triathlete_sponsorship_web.services.TriathleteService;
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
public class TriathleteController {

    @Autowired
    private TriathleteService triathleteService;

    @GetMapping("/")
    public String listTriathletes(Model model) {
        List<TriathleteResponseDTO> triathletes = triathleteService.readAllTriathletes();
        model.addAttribute("listTriathletes", triathletes);
        return "list-triathletes";
    }

    @GetMapping("/new")
    public String newTriathlete(Model model) {
        model.addAttribute("newTriathlete", new TriathleteRequestDTO(null, null, null, List.of()));
        return "new-triathlete";
    }

    @PostMapping("/save")
    public String saveTriathlete(@ModelAttribute("newTriathlete") @Valid TriathleteRequestDTO dto, BindingResult errors,
                                 RedirectAttributes attributes) {
        if(errors.hasErrors()) {
            return "new-triathlete";
        }
        triathleteService.createTriathlete(dto);
        attributes.addFlashAttribute("message", TriathleteSponsorshipMessages.TRIATHLETE_SAVED_SUCCESSFULLY);
        return "redirect:/new";
    }

    @GetMapping("/delete/{id}")
    public String deleteTriathlete(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            triathleteService.deleteTriathlete(id);
        } catch (TriathleteNotFoundException e) {
            attributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/";
    }

}
