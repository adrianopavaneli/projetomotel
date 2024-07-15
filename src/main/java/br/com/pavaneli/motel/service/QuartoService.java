package br.com.pavaneli.motel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pavaneli.motel.dto.QuartoDto;
import br.com.pavaneli.motel.entity.Quarto;
import br.com.pavaneli.motel.repository.QuartoRepository;

@Service
public class QuartoService {

	@Autowired
	private QuartoRepository quartoRepository;
	
	public List<QuartoDto> findAll(){
		List<Quarto> quartos = quartoRepository.findAll();
		return quartos.stream().map(QuartoDto::new).toList();
    }
	public void insert(QuartoDto quartoDto) {
		Quarto quarto = new Quarto(quartoDto);
        quartoRepository.save(quarto);
	}
	public QuartoDto update(QuartoDto quartoDto) {
        Quarto quarto = new Quarto(quartoDto);
        return new QuartoDto(quartoRepository.save(quarto));
    }
	public void delete(Long id) {
        Quarto quarto = quartoRepository.findById(id).get();
		quartoRepository.delete(quarto);
    }
	public QuartoDto findById(Long id) {
        return new QuartoDto(quartoRepository.findById(id).get());
    }
}
