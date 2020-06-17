package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class InstitutionController {
    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

//    @ModelAttribute("institutions")
//    public List<Institution> institutions(){
//        return institutionService.readAll();
//    }

    @GetMapping("/")
    public String getList(Model model){
        model.addAttribute("institutions", institutionService.readAll());
        return "index";
    }
}
