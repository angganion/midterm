package id.ac.ui.cs.eaap.lab.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import id.ac.ui.cs.eaap.lab.model.KamarModel;
import id.ac.ui.cs.eaap.lab.model.LokasiModel;
import id.ac.ui.cs.eaap.lab.service.KamarService;
import id.ac.ui.cs.eaap.lab.service.ListService;
import id.ac.ui.cs.eaap.lab.service.LokasiService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/lokasi")
public class LokasiController {

   

    private final LokasiService lokasiService;
    private final ListService listService;
    private final KamarService kamarService;
    public LokasiController(LokasiService lokasiService, ListService listService, KamarService kamarService) {
        this.lokasiService = lokasiService;
        this.listService = listService;
        this.kamarService = kamarService;
    }


    @GetMapping("/view-all")
    public String viewAllPage(Model model) {
        log.info("view all kamar");
        List<LokasiModel> lokasiModels = new ArrayList<>();
        lokasiModels = lokasiService.findAll();
        model.addAttribute("lokasiList", lokasiModels);
        return "lokasi/view-all";
    }


    @GetMapping("/add")
    public String addFormPage(Model model) {

        LokasiModel lokasiModel = new LokasiModel();

        model.addAttribute("lokasiModel", lokasiModel);
        model.addAttribute("listService", listService);

        return "lokasi/form-add";
    }

    @PostMapping(value = "/add", params = {"save"})
    public String addSubmitPage(@ModelAttribute LokasiModel lokasiModel, BindingResult result,
                                RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("error", "The error occurred.");
            return "redirect:/lokasi/add";
        }

        lokasiService.addLokasi(lokasiModel);

        redirectAttrs.addFlashAttribute("success",
                String.format("Lokasi berhasil disimpan dengan id %d", lokasiModel.getLokasiId()));
        return "redirect:/lokasi/view-all";
    }


    @GetMapping("/{id}/view")
    public String detail(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs) {
        boolean present = false;
        LokasiModel a = lokasiService.findById(id);
        List<KamarModel> c = kamarService.getLokasi(id);
        KamarModel b = new KamarModel();
        present = true;
        if (present) {

            b.setLokasiModel(a);
            model.addAttribute("listKamar", c);
            model.addAttribute("lokasiModel", a);
            model.addAttribute("kamarModel", b);
            model.addAttribute("listService", listService);

            return "lokasi/detail";

        } else {
            return "redirect:/lokasi/view-all";

        }
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "name") String name, Model model) {
        List<LokasiModel> lokasiModels = new ArrayList<>();
        lokasiModels = lokasiService.getBySearch(name);
        model.addAttribute("lokasiList", lokasiModels);
        return "lokasi/view-all";
    }



}
