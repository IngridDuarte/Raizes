package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Cliente;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.dominio.TipoDeUsuario;
import com.thoughtworks.aceleradora.dominio.Usuario;
import com.thoughtworks.aceleradora.repositorios.CidadeRepositorio;
import com.thoughtworks.aceleradora.repositorios.EstadoRepositorio;
import com.thoughtworks.aceleradora.servicos.RegistrarServico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
// @RequestMapping("/selecionaUsuario.html")
public class UsuarioControlador {
    private RegistrarServico registrarServico;
    private CidadeRepositorio cidadeRepositorio;
    private EstadoRepositorio estadoRepositorio;

    public UsuarioControlador(RegistrarServico registrarServico,
                              CidadeRepositorio cidadeRepositorio,
                              EstadoRepositorio estadoRepositorio) {
        this.registrarServico = registrarServico;
        this.cidadeRepositorio = cidadeRepositorio;
        this.estadoRepositorio = estadoRepositorio;
    }

    @GetMapping(value = "/registrar/cliente")
    public String registrarCliente(Model model) {
        model.addAttribute("formUsuario", new Cliente());
        model.addAttribute("tipoUsuario", TipoDeUsuario.values());
        model.addAttribute("cidade", cidadeRepositorio.findAll());
        model.addAttribute("estado", estadoRepositorio.findAll());

        return "registrarUsuario/registrarCliente";
    }

    @GetMapping(value = "/registrar/produtor")
    public String registrarProdutor(Model model) {
        model.addAttribute("formUsuario", new Produtor());
        model.addAttribute("tipoUsuario", TipoDeUsuario.values());
        model.addAttribute("cidade", cidadeRepositorio.findAll());
        model.addAttribute("estado", estadoRepositorio.findAll());

        return "registrarUsuario/registrarProdutor";
    }


    @GetMapping(value = "/selecionaUsuario")
    public String selecionaUsuario(Model modelo){
        return "registrarUsuario/selecionaUsuario";
    }


    @PostMapping(value = "/registrar/cliente")
    public String registrarCliente(@ModelAttribute("formUsuario") Cliente cliente, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
            return "registrarUsuario/registrar/cliente";
        }

        registrarServico.salvarCliente(cliente);

        return "redirect:/login";
    }

    @PostMapping(value = "/registrar/produtor")
    public String registrarProdutor(@ModelAttribute("formUsuario") Produtor produtor, BindingResult bindingResult) {


        if(bindingResult.hasErrors()) {
            return "registrarUsuario/registrar/produtor";
        }

        registrarServico.salvarProdutor(produtor);

        return "redirect:/login";
    }



    @GetMapping(value = "/login")
    public String login(Model modelo) {
        return "login/login";
    }

}
