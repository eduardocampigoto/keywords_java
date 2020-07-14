package com.aceville.Indexador.service;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.aceville.Indexador.Repository.KeywordResponseRepository;
import com.aceville.Indexador.dto.KeywordResponseDTO;
import com.aceville.Indexador.mapper.KeywordResponseMapper;
import com.aceville.Indexador.model.Keyword;
import com.aceville.Indexador.model.KeywordResponse;

@Service
public class KeywordResponseService {

	@Inject
	private KeywordResponseRepository repository;
	
	@Inject
	private KeywordResponseMapper mapper;
	
	public List<KeywordResponseDTO> findAll(){
		return mapper.toDTO(repository.findAll());
	}
	
	public List<KeywordResponseDTO> findByKeyword(String keyword){
		
		return mapper.toDTO(repository.findBykeyword(new Keyword(keyword)));
	}
	
	public KeywordResponseDTO createKeywordResponse(List<String> keys,String response) {
		
		List<Keyword> keywords = keys.stream().map(key-> new Keyword(key)).collect(Collectors.toList());
		
		KeywordResponse keywordResponse = KeywordResponse.builder().keyword(keywords).response(response).build();
		
		this.repository.save(keywordResponse);
		
		return mapper.toDTO(keywordResponse);
	}
	
	}
