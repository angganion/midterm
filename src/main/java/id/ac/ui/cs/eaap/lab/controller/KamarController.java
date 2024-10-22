package id.ac.ui.cs.eaap.lab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import id.ac.ui.cs.eaap.lab.model.KamarModel;
import id.ac.ui.cs.eaap.lab.service.KamarService;
import id.ac.ui.cs.eaap.lab.service.ListService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/kamar")
public class KamarController {

    @Autowired
    ListService listService;

    @Autowired
    KamarService kamarService;


    @GetMapping("/view-all")
    public String viewAllKamar(Model model) {
        // TODO
        log.info("view all kamar");
        return "kamar/view-all";
    }


    @PostMapping(value = "/add", params = {"save"})
    public String addKamarSubmitPage(@ModelAttribute KamarModel kamarModel, BindingResult result,
                                     RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("error", "The error occurred.");
            return "redirect:/kamar/view-all";
        }
        kamarService.addKamar(kamarModel);

        redirectAttrs.addFlashAttribute("success",
                String.format("Kamar berhasil disimpan dengan id %d", kamarModel.getKamarId()));
        return "redirect:/kamar/view-all";
    }


    @GetMapping(value = "/{id}/update")
    public String updateStatus(@PathVariable Long id, Model model) {
        KamarModel a = kamarService.getKamarById(id);
        model.addAttribute("kamarModel", a);
        model.addAttribute("listService", listService);

        return "kamar/form-update-status";
    }

    @PostMapping(value = "/update", params = {"save"})
    public String updateStatus(@ModelAttribute KamarModel kamarModel, BindingResult result,
                               RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("error", "The error occurred.");
            return "redirect:/kamar/view-all";
        }

        kamarService.updateStatus(kamarModel);

        redirectAttrs.addFlashAttribute("success",
                "Status berhasil di update");
        return "redirect:/kamar/view-all";
    }

    @GetMapping("/tersedia")
    public String viewKamarTersedia(Model model) {
        log.info("view kamar tersedia");
        List<KamarModel> a = kamarService.getTersedia();
        model.addAttribute("listKamar", a);
        return "kamar/view-all";
    }
}
