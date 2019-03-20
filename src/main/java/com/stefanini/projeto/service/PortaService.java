package com.stefanini.projeto.service;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.projeto.dao.PortaDAO;
import com.stefanini.projeto.model.Chave;
import com.stefanini.projeto.model.Porta;

public class PortaService {
	
	 
	/*Por algum motivo nao está dando certo com @Inject
	@Inject
	 private PortaDAO portaDao;*/
	PortaDAO portaDao = new PortaDAO();
	
	public List<Porta> findAll() {
		return portaDao.findAll();
	}
	public void deletar(Integer id) {
		portaDao.deletar(id);
	}
	public String adicionar(Porta porta) {
		String resposta = "inicializacao";
			if(porta.getCor().length() > 20) {
				resposta = "Maximo de 20 caracteres";
			} else {
				List<Porta> po = portaDao.findAll();
				for(Porta p: po) {
					if(p.getCor().equals(porta.getCor())) {
						resposta = "falso";
					}
					
				}
				if(resposta.equals("falso")) {
					resposta = "Cor existente";
				}else {
					portaDao.salvar(porta);
					resposta = "Sucesso";
				}
			}
		return resposta;
	}
	public String alterar(Porta porta) {
		String resposta = "inicializacao";
		if(porta.getCor().length() > 20) {
			resposta = "Maximo de 20 caracteres";
		} else {
			List<Porta> po = portaDao.findAll();
			for(Porta p: po) {
				if(p.getCor().equals(porta.getCor())) {
					resposta = "falso";
				}
				
			}
			if(resposta.equals("falso")) {
				resposta = "Cor existente";
			}else {
				portaDao.alterar(porta);
				resposta = "Sucesso";
			}
		}
	return resposta;
	}
	public String addChave(Chave chave) {
		String resposta = "inicializacao";
		Porta porta = portaDao.obterPortaParaChave(chave.getPortaid());
		if(porta.getChaves().size() >= 5) {
			resposta = "quantidade de chaves maximas adicionadas";
		}else {
		portaDao.addChave(chave);
		resposta = "sucesso";
		}
		return resposta;
	}
	public void setPortaDAO(PortaDAO portadao) {
		this.portaDao = portaDao;
	}
}
