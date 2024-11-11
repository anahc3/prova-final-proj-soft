package com.example.pf.controller;

import com.example.pf.dto.RetornarUsuarioDTO;
import com.example.pf.exception.AccessDeniedException;
import com.example.pf.model.Artigo;
import com.example.pf.service.ArtigoService;
import com.example.pf.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    @Autowired
    private AuthService authService;

    @PostMapping
    public Artigo criarArtigo(@RequestHeader("Authorization") String token, @RequestBody Artigo artigo) {
        RetornarUsuarioDTO usuario = authService.validarToken(token);
        if (!"ADMIN".equals(usuario.getPapel())) {
            throw new AccessDeniedException("Acesso negado: Apenas ADMIN pode criar artigos.");
        }
        return artigoService.criarArtigo(artigo);
    }

    @DeleteMapping("/{id}")
    public void deletarArtigo(@RequestHeader("Authorization") String token, @PathVariable String id) {
        RetornarUsuarioDTO usuario = authService.validarToken(token);
        if (!"ADMIN".equals(usuario.getPapel())) {
            throw new RuntimeException("Acesso negado: Apenas ADMIN pode deletar artigos.");
        }
        artigoService.deletarArtigo(id);
    }

    @GetMapping
    public List<Artigo> listarArtigos(@RequestHeader("Authorization") String token) {
        authService.validarToken(token);
        return artigoService.listarArtigos();
    }

    @GetMapping("/{id}")
    public Artigo obterArtigoPorId(@RequestHeader("Authorization") String token, @PathVariable String id) {
        authService.validarToken(token);
        return artigoService.obterArtigoPorId(id);
    }
}

