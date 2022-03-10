package edu.wctc.datajpaassignment.controller;

import edu.wctc.datajpaassignment.entity.Mug;
import edu.wctc.datajpaassignment.service.MugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private MugService mugService;

    @Autowired
    public HomeController(MugService ms) {
        this.mugService = ms;
    }


    @RequestMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("pageTitle", "About");
        model.addAttribute("mugList", mugService.getMugList());
        return "catalog";
    }

    @RequestMapping("/inventory")
    public String showInventoryPage(Model model) {
        model.addAttribute("pageTitle", "About");
        model.addAttribute("mugList", mugService.getMugList());
        return "inventory";
    }

    @PostMapping("/decrement")
    public void decrementMugStock(Model model, Mug mug) {

        if(mug.getStock() != 0) {
            Mug updatedMug = mugService.getMug(mug.getId());

            mugService.decrementStock(updatedMug);
            mugService.updateMug(updatedMug);
        } else {
            model.addAttribute("hasZeroStock", true);
        }
    }
}
