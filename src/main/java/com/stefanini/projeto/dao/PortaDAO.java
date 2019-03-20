package com.stefanini.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.stefanini.projeto.model.Chave;
import com.stefanini.projeto.model.Porta;
import com.stefanini.projeto.util.HibernateUtil;

public class PortaDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public List<Porta> findAll() {
		return entityManager.createQuery("select distinct p from Porta p left join p.chaves", Porta.class).getResultList();
	}
	
	public void salvar(Porta porta) {
		/*Porta p = new Porta();
		p.setCor(porta.getCor());*/
		entityManager.getTransaction().begin();
		entityManager.persist(porta);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	public void deletar(Integer id) {
		entityManager.getTransaction().begin();
		Porta porta = entityManager.find(Porta.class, id);
		entityManager.remove(porta);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	public void alterar(Porta porta) {
		entityManager.getTransaction().begin();
		Porta p = entityManager.find(Porta.class, porta.getId());
		p.setCor(porta.getCor());
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	public void addChave(Chave chave) {
		Porta p = entityManager.find(Porta.class, chave.getPortaid());
		chave.setPorta(p);
		entityManager.persist(chave);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	public Porta obterPortaParaChave(Integer id) {
		entityManager.getTransaction().begin();
		Porta porta = entityManager.find(Porta.class, id);
		return porta;
	}


}