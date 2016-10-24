package br.com.auron.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.auron.dao.ProdutoDao;
import br.com.auron.modelo.Produto;
import br.com.auron.modelo.Venda;

@Named
@RequestScoped
public class vendaBean {

	private Venda venda = new Venda();
	@Inject
	private ProdutoDao produtoDao;
	private List<Produto> c ;
	private Map<Integer, Produto> carrinho;
	private Map<Integer, Produto> carrinhoCompra;
	
	@PostConstruct
	public void init(){
		c = this.produtoDao.listaTodos();
		carrinho = new HashMap<>();
		for (Produto p : c) {
			carrinho.put(p.getId(), p);
		}
		carrinhoCompra = new HashMap<>();
	}
	
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Produto> getCarrinho() {
		List<Produto> c = carrinho.;
		return c;
	}

	public Map<Integer, Produto> getCarrinhoCompra() {
		return carrinhoCompra;
	}

	public void addCarrinho(Produto produto) {
		this.carrinhoCompra.put(produto.getId(), produto);
		this.carrinho.remove(produto);
	}

}
