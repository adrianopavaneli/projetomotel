package br.com.pavaneli.motel.dto;

import org.springframework.beans.BeanUtils;

import br.com.pavaneli.motel.entity.Quarto;
import br.com.pavaneli.motel.entity.TipoQuarto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuartoDto {
	private Long id;	
	private String descricao;	    
	private Double valor_hora;	
	private Double valor_pernoite;	
    private String status;	
	private TipoQuarto tipoquarto;	
	
	
	  public QuartoDto(Quarto quarto) {
	        BeanUtils.copyProperties(quarto, this);
	    }

}
