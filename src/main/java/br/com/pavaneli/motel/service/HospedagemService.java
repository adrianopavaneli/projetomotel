package br.com.pavaneli.motel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pavaneli.motel.dto.HospedagemDto;
import br.com.pavaneli.motel.entity.Hospedagem;
import br.com.pavaneli.motel.repository.HospedagemRepository;

@Service
public class HospedagemService {
	@Autowired
	private HospedagemRepository hospedagemRepository;

	public List<HospedagemDto> findAll() {
		List<Hospedagem> hospedagens = hospedagemRepository.findAll();
		return hospedagens.stream().map(HospedagemDto::new).toList();

	}
	public void insert(HospedagemDto hospedagemDto) {
		Hospedagem hospedagem = new Hospedagem(hospedagemDto);
        hospedagemRepository.save(hospedagem);
        
	}
	public HospedagemDto update(HospedagemDto hospedagemDto) {
		Hospedagem hospedagem = new Hospedagem(hospedagemDto);
        return new HospedagemDto(hospedagemRepository.save(hospedagem));
    }
	public void delete(Long id) {
		Hospedagem hospedagem = hospedagemRepository.findById(id).get();
        hospedagemRepository.delete(hospedagem);
    }
	public HospedagemDto findById(Long id) {
		return new HospedagemDto(hospedagemRepository.findById(id).get());
	}
	
	
}