package com.example.pf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pf.model.Artigo;
import com.example.pf.repository.ArtigoRepository;

import java.util.List;

@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    public Artigo criarArtigo(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    public void deletarArtigo(String id) {
        artigoRepository.deleteById(id);
    }

    public List<Artigo> listarArtigos() {
        return artigoRepository.findAll();
    }

    public Artigo obterArtigoPorId(String id) {
        return artigoRepository.findById(id).orElse(null);
    }
}

