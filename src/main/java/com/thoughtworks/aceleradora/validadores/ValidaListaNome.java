package com.thoughtworks.aceleradora.validadores;

import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import com.thoughtworks.aceleradora.validadores.anotacoes.NomeValido;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidaListaNome implements ConstraintValidator<NomeValido, String> {
    @Autowired
    MinhaListaRepositorio repositorio;

    @Override
    public void initialize(NomeValido constraintAnnotation) {
    }

    @Override
    public boolean isValid(String nomeLista, ConstraintValidatorContext context) {
        return !repositorio.findByNome(nomeLista).isPresent() && !nomeLista.trim().isEmpty();
    }
}