package br.com.pavaneli.motel.dto.requisicoes;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.pavaneli.motel.entity.Hospedagem;
import br.com.pavaneli.motel.entity.ItemPedido;
import br.com.pavaneli.motel.entity.Produto;
import br.com.pavaneli.motel.repository.HospedagemRepository;
import br.com.pavaneli.motel.repository.ItemPedidoRepository;
import br.com.pavaneli.motel.repository.ProdutoRepository;
import br.com.pavaneli.motel.repository.QuartoRepository;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RequisicaoNovoPedido {
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
    private QuartoRepository quartoRepository;
	@Autowired
	private HospedagemRepository hospedagemRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	private Long produtoId;
    private Long hospedagemId;
    private Integer quantidadePedido;

    public ItemPedido toItemPedido(ProdutoRepository produtoRepository, HospedagemRepository hospedagemRepository) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(quantidadePedido);

        if (hospedagemId != null) {
            Hospedagem hospedagemEntity = hospedagemRepository.findById(hospedagemId)
                .orElseThrow(() -> new IllegalArgumentException("Hospedagem não encontrada"));
            itemPedido.setHospedagem(hospedagemEntity);
            hospedagemEntity.getItensPedidos().add(itemPedido); // Adiciona o pedido à lista de pedidos da hospedagem
        }

        if (produtoId != null) {
            Produto produtoEntity = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
            itemPedido.setProduto(produtoEntity);
            itemPedido.setPrecoTotal(produtoEntity.getPreco() * quantidadePedido);
        }

        return itemPedido;
    }
	
	
	
	
	
	
	
	

}
