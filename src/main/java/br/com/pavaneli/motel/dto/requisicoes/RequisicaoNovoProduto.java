package br.com.pavaneli.motel.dto.requisicoes;

import br.com.pavaneli.motel.entity.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoNovoProduto {
	
	private String descricaoProduto;
	private String unidadeProduto;
	private String precoProduto;
	private String statusProduto;
	
	

	public Produto toProduto() {
		Produto produto = new Produto();
		produto.setDescricao(descricaoProduto);
		produto.setUnidade(unidadeProduto);
		Double precoCerto = Double.parseDouble(precoProduto);
		produto.setPreco(precoCerto);
		produto.setStatus(statusProduto);
		return produto;
	}
	

}
