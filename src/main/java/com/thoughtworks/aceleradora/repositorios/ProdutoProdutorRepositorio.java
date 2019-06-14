package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoProdutorRepositorio extends CrudRepository<ProdutoProdutor, Long> {

    Optional<ProdutoProdutor> findById(Long id);

}