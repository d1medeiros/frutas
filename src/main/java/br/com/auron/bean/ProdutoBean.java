package br.com.auron.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.auron.dao.FornecedorDao;
import br.com.auron.dao.ProdutoDao;
import br.com.auron.modelo.Fornecedor;
import br.com.auron.modelo.Produto;

@Named
@RequestScoped
public class ProdutoBean {

		
		private Produto produto = new Produto();
		@Inject
		private ProdutoDao produtoDao;
		@Inject
		private FornecedorDao fornecedorDao;
		private Integer fornecedorId;
		
		
		public Produto getProduto() {
			return produto;
		}

		public List<Produto> getProdutos() {
			return this.produtoDao.listaTodos();
		}
		
		public void cadastrar(){
			System.out.println("Cadastrando " + produto.getNome());
			addFornecedorPorId(this.fornecedorId);
			this.produtoDao.inserir(produto);
			produto = new Produto();
		}

		private void addFornecedorPorId(Integer fornecedorId) {
			Fornecedor f = this.fornecedorDao.fornecedorPorId(fornecedorId);
			this.produto.setFornecedor(f);
		}

		public void remover(Produto produto){
			System.out.println("Removendo" + produto.getNome());
			this.produtoDao.remover(produto);
		}

		public List<Fornecedor> getFornecedores() {
			return fornecedorDao.listaTodos();
		}

		public Integer getFornecedorId() {
			return fornecedorId;
		}

		public void setFornecedorId(Integer fornecedorId) {
			this.fornecedorId = fornecedorId;
		}

}
