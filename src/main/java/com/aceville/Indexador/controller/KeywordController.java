package com.aceville.Indexador.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aceville.Indexador.dto.KeywordResponseDTO;
import com.aceville.Indexador.model.Keyword;
import com.aceville.Indexador.service.KeywordResponseService;
import com.aceville.Indexador.service.KeywordService;


@RestController
@RequestMapping("/api")
public class KeywordController {

	@Inject
	private KeywordService keywordService;

	@Inject
	private KeywordResponseService keywordResponseService;

	@PostMapping(value = "/palavra-chave", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> createKeyword(@RequestParam("chave") List<String> keys) {

		keywordService.createKeyword(keys);
		return new ResponseEntity<>(keys, HttpStatus.CREATED);
	}

	
	@PostMapping(value = "/resposta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KeywordResponseDTO> createResponseForKeyword(@RequestParam("chave") List<String> chave, @RequestParam("resposta") String resposta) {
		return new ResponseEntity<>(keywordResponseService.createKeywordResponse(chave, resposta), HttpStatus.CREATED);
	} 

	@GetMapping(value = "/resposta/{chave}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KeywordResponseDTO>> findResponseByKeyworkd(@PathVariable("chave") String chave) {
		return new ResponseEntity<>(keywordResponseService.findByKeyword(chave), HttpStatus.OK);
	}

	@GetMapping(value = "/resposta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KeywordResponseDTO>> listResponses() {
		return new ResponseEntity<>(keywordResponseService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/palavra-chave/{chave}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> listKeywordsByName(@PathVariable("chave") String chave) {
		List<String> keys = keywordService.findByName(chave).stream().map(Keyword::getKeywd).collect(Collectors.toList());
		return new ResponseEntity<>(keys, HttpStatus.OK);
	}
	
	@GetMapping(value = "/palavra-chave", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> listKeywords() {

		List<String> keys = keywordService.listKeywords().stream().map(Keyword::getKeywd).collect(Collectors.toList());
		return new ResponseEntity<>(keys, HttpStatus.OK);
	}

}