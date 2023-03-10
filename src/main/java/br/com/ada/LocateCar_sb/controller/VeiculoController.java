package br.com.ada.LocateCar_sb.controller;

import br.com.ada.LocateCar_sb.model.Veiculo;
import br.com.ada.LocateCar_sb.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/veiculos")
    public String veiculos(Model model) {
        List<Veiculo> veiculos = this.veiculoService.listarTodos();
        model.addAttribute("veiculos", veiculos);
        return "veiculos";
    }

    @GetMapping("/veiculo/add")
    public String mostrarAddVeiculo(Model model) {
        model.addAttribute("add", Boolean.TRUE);
        model.addAttribute("veiculo", new Veiculo());
        return "veiculo-add";
    }

    @PostMapping("/veiculo/add")
    public String addVeiculo(@ModelAttribute("veiculo") Veiculo veiculo) {
        this.veiculoService.createVeiculo(veiculo);
        return "redirect:/veiculos";
    }

    @GetMapping("/veiculo/{veiculoId}/delete")
    public String deletarVeiculo (@PathVariable("veiculoId") Long veiculoId) {
        this.veiculoService.removerVeiculoPorId(veiculoId);
        return "redirect:/veiculos";
    }

}