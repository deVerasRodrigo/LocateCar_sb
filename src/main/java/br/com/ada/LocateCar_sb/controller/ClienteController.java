package br.com.ada.LocateCar_sb.controller;

import br.com.ada.LocateCar_sb.model.Cliente;
import br.com.ada.LocateCar_sb.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public String clientes(Model model) {
        List<Cliente> clientes = this.clienteService.listarTodos();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/cliente/add")
    public String mostrarAddCliente(Model model) {
        model.addAttribute("add", Boolean.TRUE);
        model.addAttribute("cliente", new Cliente());
        return "cliente-add";
    }

    @PostMapping("/cliente/add")
    public String addCliente (@ModelAttribute("cliente") Cliente cliente) {
        this.clienteService.createCliente(cliente);
        return "redirect:/clientes";
    }
    @GetMapping("/cliente/{clienteId}/delete")
    public String deletarCliente (@PathVariable("clienteId") Long clienteId) {
        this.clienteService.removerClientePorId(clienteId);
        return "redirect:/clientes";
    }
    @GetMapping("/cliente/{clienteId}/edit")
    public String mostrarEditCliente(Model model, @PathVariable("clienteId") Long clienteId) {
        model.addAttribute("add", Boolean.FALSE);
        Optional<Cliente> optionalCliente = this.clienteService.buscarClientePorId(clienteId);
        optionalCliente.ifPresent(cliente -> model.addAttribute("cliente", cliente));
        return "cliente-add";
    }

    @PutMapping("/cliente/{clienteId}/edit")
    public String EditVeiculo(@PathVariable("clienteId") Long clienteId, @ModelAttribute("cliente") Cliente cliente){
        cliente.setId(clienteId);
        this.clienteService.createCliente(cliente);
        return "redirect:/clientes";
    }

}

