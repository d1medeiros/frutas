package br.com.auron.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.auron.dao.FornecedorDao;
import br.com.auron.modelo.Fornecedor;

@Named
@RequestScoped
public class FornecedorBean {

		
		private Fornecedor fornecedor = new Fornecedor();
		@Inject
		private FornecedorDao fornecedorDao;
		
		public Fornecedor getFornecedor() {
			return fornecedor;
		}

		public List<Fornecedor> getFornecedores() {
			return this.fornecedorDao.listaTodos();
		}
		
		public void cadastrar(){
			System.out.println("Cadastrando " + fornecedor.getNome());
			this.fornecedorDao.inserir(fornecedor);
			fornecedor = new Fornecedor();
		}

		public void remover(Fornecedor fornecedor){
			System.out.println("Removendo" + fornecedor.getNome());
			this.fornecedorDao.remover(fornecedor);
		}
}
