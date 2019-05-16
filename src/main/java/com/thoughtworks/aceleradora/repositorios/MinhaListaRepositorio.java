package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MinhaListaRepositorio extends CrudRepository<MinhaLista, Long> {
    Optional<MinhaLista> findByNome(String nome);
}

