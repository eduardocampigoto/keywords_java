package com.aceville.Indexador.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceville.Indexador.model.Keyword;
import com.aceville.Indexador.model.KeywordResponse;



public interface KeywordResponseRepository extends JpaRepository<KeywordResponse, Long> {


	List<KeywordResponse> findBykeyword(Keyword keyword);
}
