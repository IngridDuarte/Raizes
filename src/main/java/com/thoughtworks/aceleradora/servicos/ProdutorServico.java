package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.repositorios.ProdutorRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ProdutorServico {
    private ProdutorRepositorio repositorio;

    public Produtor encontraUm(Long id){
        return repositorio.findById(id).get();
    }
}
