package com.fiap.mercadoexpresssecurity.controller;

import com.fiap.mercadoexpresssecurity.exception.EmailJaCadastradoException;
import com.fiap.mercadoexpresssecurity.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastroFormulario() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@RequestParam String nome,
                             @RequestParam String email,
                             @RequestParam String senha,
                             RedirectAttributes redirectAttributes) {
        try {
            usuarioService.cadastrar(nome, email, senha);
            redirectAttributes.addFlashAttribute("mensagem", "Cadastro realizado com sucesso. Faça login para continuar.");
            return "redirect:/login";
        } catch (EmailJaCadastradoException ex) {
            redirectAttributes.addFlashAttribute("erro", ex.getMessage());
            return "redirect:/cadastro";
        }
    }

}
