package br.com.pavaneli.motel.dto;

import org.springframework.beans.BeanUtils;

import br.com.pavaneli.motel.entity.TipoQuarto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TipoQuartoDto {
	private Long id;			
	private String descricao;	
	
	
	  public TipoQuartoDto(TipoQuarto tipoQuarto) {
	        BeanUtils.copyProperties(tipoQuarto, this);
	    }

}
