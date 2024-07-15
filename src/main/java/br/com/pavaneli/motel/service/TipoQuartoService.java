package br.com.pavaneli.motel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pavaneli.motel.dto.TipoQuartoDto;
import br.com.pavaneli.motel.entity.TipoQuarto;
import br.com.pavaneli.motel.repository.TipoQuartoRepository;

@Service
public class TipoQuartoService {
	
	@Autowired
	private TipoQuartoRepository tipoQuartoRepository;	
	
	
	public List<TipoQuartoDto> findAll(){
		List<TipoQuarto> tipoQuartos = tipoQuartoRepository.findAll();
		return tipoQuartos.stream().map(TipoQuartoDto::new).toList();
		
	}
	public void insert(TipoQuartoDto tipoQuartoDto){
		TipoQuarto tipoQuarto = new TipoQuarto(tipoQuartoDto);
        tipoQuartoRepository.save(tipoQuarto);
	}
	public TipoQuartoDto update(TipoQuartoDto tipoQuartoDto){
        TipoQuarto tipoQuarto = new TipoQuarto(tipoQuartoDto);
        return new TipoQuartoDto(tipoQuartoRepository.save(tipoQuarto));
    }
	public void delete(Long id) {
        TipoQuarto tipoQuarto = tipoQuartoRepository.findById(id).get();
        tipoQuartoRepository.delete(tipoQuarto);
    }
	public TipoQuartoDto findById(Long id) {
        return new TipoQuartoDto(tipoQuartoRepository.findById(id).get());
    }

}
