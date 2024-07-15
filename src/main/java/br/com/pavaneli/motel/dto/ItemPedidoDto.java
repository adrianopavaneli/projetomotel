package br.com.pavaneli.motel.dto;

import org.springframework.beans.BeanUtils;

import br.com.pavaneli.motel.entity.ItemPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ItemPedidoDto {
	
	private Long id;
    private String produtoNome;
    private int quantidade;
    private Double precoTotal;

    // construtor, getters e setters
    
    public ItemPedidoDto(ItemPedido itemPedido) {
		BeanUtils.copyProperties(itemPedido, this);
	}


}