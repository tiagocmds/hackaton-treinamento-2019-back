package com.stefanini.projeto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.stefanini.projeto.dao.PortaDAO;
import com.stefanini.projeto.model.Chave;
import com.stefanini.projeto.model.Porta;
import com.stefanini.projeto.service.PortaService;
import com.stefanini.projeto.util.HibernateUtil;

public class teste {
	public static void main(String[] args) {
		EntityManager em = HibernateUtil.getEntityManager();
		PortaDAO dao = new PortaDAO();
		PortaService s = new PortaService();
		Porta porta = new Porta();
		porta.setCor("Vermelho");
	
		
		Chave c1 = new Chave();
		c1.setCodigo(4);
		c1.setPorta(porta);
		Chave c2 = new Chave();
		c2.setCodigo(5);
		c2.setPorta(porta);
		Chave c3 = new Chave();
		c3.setCodigo(6);
		c3.setPorta(porta);
		
		List<Chave> chaves = new ArrayList<>();
		chaves.add(c1);
		chaves.add(c2);
		chaves.add(c3);
		porta.setChaves(chaves);
		
		System.out.println(s.adicionar(porta));
		}
	}

