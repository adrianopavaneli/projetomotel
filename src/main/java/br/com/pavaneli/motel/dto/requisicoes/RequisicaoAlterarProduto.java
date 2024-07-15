package br.com.pavaneli.motel.dto.requisicoes;

import br.com.pavaneli.motel.entity.Produto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RequisicaoAlterarProduto {
	private String idProduto;
	private String descricaoProduto;
	private String unidadeProduto;
	private String precoProduto;
	private String statusProduto;

	// Getters e Setters

	

	public Produto toProduto() {
	    Produto produto = new Produto();
	    if (idProduto != null && !idProduto.isEmpty()) {
	        produto.setId(Long.parseLong(idProduto));
	    }
	    produto.setDescricao(descricaoProduto);
	    produto.setUnidade(unidadeProduto);
	    produto.setPreco(Double.parseDouble(precoProduto));
	    produto.setStatus(statusProduto);
	    return produto;
	}
}
