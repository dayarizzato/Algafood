package com.algaworks.algafood.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class AtaulizaRestauranteMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext =new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante = new Restaurante();
		
		restaurante.setId(1L);
		restaurante.setNome("Restaurante Italiano");
		restaurante.setTaxaFrete(BigDecimal.valueOf(30.00));
		
		restaurante = restaurantes.save(restaurante);
		
		System.out.printf("%d %s %s\n", restaurante.getId(), restaurante.getNome(), restaurante.getTaxaFrete());
	}
}
