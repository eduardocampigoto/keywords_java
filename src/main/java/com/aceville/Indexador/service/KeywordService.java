package com.aceville.Indexador.service;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.aceville.Indexador.Repository.KeywordRepository;
import com.aceville.Indexador.model.Keyword;


@Service
public class KeywordService {

	@Inject
	private KeywordRepository repository;

	public List<Keyword> listKeywords() {

		return repository.findAll();
	}
	
	public void createKeyword(List<String> keys) {
		List<Keyword> keyword = keys.stream().map(key -> Keyword.builder().keywd(key).build()).collect(Collectors.toList());
		repository.saveAll(keyword);
	}
	
	public List<Keyword> findByName(String keyword) {

		return repository.findByKeywd(keyword);
	}
}