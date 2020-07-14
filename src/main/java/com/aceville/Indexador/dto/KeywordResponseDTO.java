package com.aceville.Indexador.dto;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class KeywordResponseDTO {

	private long id;
	
	private List<String> keyword;
	
	private String response;
	
}
