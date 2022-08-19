package ua.mk.berkut.demodbspring.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.mk.berkut.demodbspring.entities.Gruppa;
import ua.mk.berkut.demodbspring.repositories.GruppaRepository;
import ua.mk.berkut.demodbspring.repositories.StudentRepository;

import java.util.List;

@Controller
@AllArgsConstructor
public class DBController {

    private GruppaRepository gruppaRepository;

//    private StudentRepository studentRepository;

    @GetMapping("/groups")
    public String showAllGroups(Model model) {
        List<Gruppa> groups = gruppaRepository.findAll();
        model.addAttribute("grs", groups);
        return "groups";
    }

    @PostMapping("/add_group")
    public String addGroup(@RequestParam String group) {
        Gruppa g = new Gruppa();
        g.setName(group);
        gruppaRepository.save(g);

        return "redirect:/groups";
    }

    @GetMapping("/delete_group/{id}")
    public String deleteGroup(@PathVariable("id") int id) {
        gruppaRepository.deleteById(id);

        return "redirect:/groups";
    }
}
