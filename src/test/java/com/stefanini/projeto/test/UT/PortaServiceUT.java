package com.stefanini.projeto.test.UT;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.stefanini.projeto.dao.DonoDAO;
import com.stefanini.projeto.dao.PortaDAO;
import com.stefanini.projeto.enums.SituacaoEnum;
import com.stefanini.projeto.model.Chave;
import com.stefanini.projeto.model.Dono;
import com.stefanini.projeto.model.Porta;
import com.stefanini.projeto.service.DonoService;
import com.stefanini.projeto.service.PortaService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PortaServiceUT {
	
	public PortaService service = new PortaService();
	
	@Mock
	PortaDAO portadao;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		service.setPortaDAO(portadao);
		Mockito.when(portadao.findAll()).thenReturn(criarListaPortaMock());
	}
	
	@Test
	public void portaComMaisDeVinteCaracteres() {
		Porta porta = new Porta();
		porta.setCor("AAAAAAAAAAAAAAAAAAAAA");
		PortaService service = new PortaService();
		
		assertEquals("Maximo de 20 caracteres", service.adicionar(porta));
	}
	@Test
	public void portaExistente() {
		Porta porta = new Porta();
		porta.setCor("Azul");

		service.adicionar(porta);
		assertEquals("Cor existente", service.adicionar(porta));
		
	}

	private Porta criarPortaMock(String cor, Integer id) {
		Porta porta = new Porta();
		porta.setId(id);
		porta.setCor(cor);
		return porta;
	}
	private List<Porta> criarListaPortaMock() {
		Porta porta1 = criarPortaMock("Azul", 1);
		Porta porta2 = criarPortaMock("Verde", 2);
		Porta porta3 = criarPortaMock("Vermelho", 3);
		List<Porta> portas = new ArrayList<>();
		portas.add(porta1);
		portas.add(porta2);
		portas.add(porta3);
		return portas;
	}
	

}
