package com.souza.charles.triathlete_sponsorship_api.controllers;

import com.souza.charles.triathlete_sponsorship_api.dtos.TriathleteRequestDTO;
import com.souza.charles.triathlete_sponsorship_api.dtos.TriathleteResponseDTO;
import com.souza.charles.triathlete_sponsorship_api.services.TriathleteService;
import com.souza.charles.triathlete_sponsorship_api.utils.TriathleteSponsorshipMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TriathleteController {

    @Autowired
    private TriathleteService triathleteService;

    @GetMapping("/")
    public String listTriathletes(Model model) {
        List<TriathleteResponseDTO> triathletes = triathleteService.readAllTriathletes();
        model.addAttribute("triathletes", triathletes);
        return "/list-triathletes";
    }

    @GetMapping("/new")
    public String newTriathlete(Model model) {
        model.addAttribute("newTriathlete", new TriathleteRequestDTO(null, "", 18, List.of()));
        return "/new-triathlete";
    }

    @PostMapping("/save")
    public String saveTriathlete(@ModelAttribute("newTriathlete") TriathleteRequestDTO dto,
                                 RedirectAttributes attributes) {
        triathleteService.createTriathlete(dto);
        attributes.addFlashAttribute("message", TriathleteSponsorshipMessages.TRIATHLETE_SAVED_SUCCESSFULLY);
        return "redirect:/new";
    }

}
