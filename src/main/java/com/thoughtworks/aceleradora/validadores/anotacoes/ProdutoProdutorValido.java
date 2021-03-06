package com.thoughtworks.aceleradora.validadores.anotacoes;


import com.thoughtworks.aceleradora.validadores.ProdutoProdutorValidador;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy= ProdutoProdutorValidador.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ProdutoProdutorValido {
  String message() default "Não foi possivel atualizar o produto";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}

