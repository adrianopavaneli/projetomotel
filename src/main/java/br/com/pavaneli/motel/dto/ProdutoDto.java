package br.com.pavaneli.motel.dto;

import org.springframework.beans.BeanUtils;

import br.com.pavaneli.motel.entity.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDto {
	private Long id;	
	private String descricao;	
	private Double preco;	
	private String unidade;	
	private String status;
	
	  public ProdutoDto(Produto produto) {
	        BeanUtils.copyProperties(produto, this);
	    }

}
