package br.com.pavaneli.motel.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.pavaneli.motel.entity.Hospedagem;
import br.com.pavaneli.motel.entity.ItemPedido;
import br.com.pavaneli.motel.entity.Quarto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
//@NoArgsConstructor
public class HospedagemDto {
	
	private Long id;	
	private String placa;
	private String descricao;	
	private Date checkin;
	private Date checkout;
	private Double valor_hospedagem;
	private Double valor_total;
	private String obs;
	private String status;
	private Quarto quarto;
	private List<ItemPedido> itensPedidos = new ArrayList<>();
	
	
	public HospedagemDto(Hospedagem hospedagem) {
		BeanUtils.copyProperties(hospedagem, this);
	}

}

