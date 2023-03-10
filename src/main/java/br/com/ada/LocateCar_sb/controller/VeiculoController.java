package br.com.ada.LocateCar_sb.controller;

import br.com.ada.LocateCar_sb.model.Veiculo;
import br.com.ada.LocateCar_sb.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public String mostrarAddVeiculo(Model model, Veiculo veiculo) {
        model.addAttribute("add", Boolean.TRUE);
        model.addAttribute("veiculo", Objects.nonNull(veiculo) ? veiculo : new Veiculo());
        return "veiculo-add";
    }

    @PostMapping("/veiculo/add")
    public String addVeiculo(@Valid @ModelAttribute("veiculo") Veiculo veiculo, BindingResult result, Model model) {
        if(result.hasErrors()){
            return mostrarAddVeiculo(model, veiculo);
        }
        this.veiculoService.createVeiculo(veiculo);
        return "redirect:/veiculos";
    }

    @GetMapping("/veiculo/{veiculoId}/delete")
    public String deletarVeiculo (@PathVariable("veiculoId") Long veiculoId) {
        this.veiculoService.removerVeiculoPorId(veiculoId);
        return "redirect:/veiculos";
    }

    @GetMapping("/veiculo/{veiculoId}/edit")
    public String mostrarEditVeiculo(Model model, @PathVariable("veiculoId") Long veiculoId) {
        model.addAttribute("add", Boolean.FALSE);
        Optional<Veiculo> optionalVeiculo = this.veiculoService.buscarVeiculoPorId(veiculoId);
        optionalVeiculo.ifPresent(veiculo -> model.addAttribute("veiculo", veiculo));
        return "veiculo-add";
    }

    @PutMapping("/veiculo/{veiculoId}/edit")
    public String EditVeiculo(@PathVariable("veiculoId") Long veiculoId, @ModelAttribute("veiculo") Veiculo veiculo){
        veiculo.setId(veiculoId);
        this.veiculoService.createVeiculo(veiculo);
        return "redirect:/veiculos";
    }

}