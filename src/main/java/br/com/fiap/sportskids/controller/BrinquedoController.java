package br.com.fiap.sportskids.controller;

import br.com.fiap.sportskids.entity.Brinquedo;
import br.com.fiap.sportskids.service.BrinquedoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/brinquedos")
public class BrinquedoController {

    private final BrinquedoService service;

    public BrinquedoController(BrinquedoService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("brinquedos", service.findAll());
        return "brinquedos/list";
    }

    @GetMapping("/novo")
    public String createForm(Model model) {
        model.addAttribute("brinquedo", new Brinquedo());
        return "brinquedos/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute Brinquedo brinquedo, BindingResult result) {
        if (result.hasErrors()) {
            return "brinquedos/form";
        }
        service.save(brinquedo);
        return "redirect:/brinquedos";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        Brinquedo b = service.findById(id);
        if (b == null) return "redirect:/brinquedos";
        model.addAttribute("brinquedo", b);
        return "brinquedos/view";
    }

    @GetMapping("/{id}/editar")
    public String editForm(@PathVariable Long id, Model model) {
        Brinquedo b = service.findById(id);
        if (b == null) return "redirect:/brinquedos";
        model.addAttribute("brinquedo", b);
        return "brinquedos/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute Brinquedo brinquedo, BindingResult result) {
        if (result.hasErrors()) {
            return "brinquedos/form";
        }
        brinquedo.setId(id);
        service.save(brinquedo);
        return "redirect:/brinquedos";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes ra) {
        service.deleteById(id);
        ra.addFlashAttribute("msg", "Brinquedo excluído!");
        return "redirect:/brinquedos";
    }
}
