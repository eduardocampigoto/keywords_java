package com.aceville.Indexador.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.aceville.Indexador.dto.KeywordResponseDTO;
import com.aceville.Indexador.model.Keyword;
import com.aceville.Indexador.model.KeywordResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class KeywordResponseMapper {

	@Mapping(target = "keyword", expression = "java( mapKeyword( keywordResponse.getKeyword() ))")
	public abstract KeywordResponseDTO toDTO(KeywordResponse keywordResponse);

	public abstract List<KeywordResponseDTO> toDTO(List<KeywordResponse> keywordResponse);

	public List<String> mapKeyword(List<Keyword> keywords) {
		
		if (keywords == null)
			return Collections.emptyList();

		return keywords.stream().map(key -> key.getKeywd()).collect(Collectors.toList());

	}
}