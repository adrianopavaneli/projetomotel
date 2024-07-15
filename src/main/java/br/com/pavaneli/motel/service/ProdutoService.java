package br.com.pavaneli.motel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pavaneli.motel.dto.ProdutoDto;
import br.com.pavaneli.motel.entity.Produto;
import br.com.pavaneli.motel.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDto> findAll(){
		List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(ProdutoDto::new).toList();
	}
	public void insert(ProdutoDto produtoDto) {
		Produto produto = new Produto(produtoDto);
		produtoRepository.save(produto);
		
	}
	public ProdutoDto update(ProdutoDto produtoDto) {
        Produto produto = new Produto(produtoDto);
        return new ProdutoDto(produtoRepository.save(produto));
    }
	public void delete(Long id) {
		Produto produto = produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }
		
	public ProdutoDto findById(Long id) {
        return new ProdutoDto(produtoRepository.findById(id).get());
    }
}
