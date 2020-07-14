package com.aceville.Indexador.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceville.Indexador.model.Keyword;

public interface KeywordRepository extends JpaRepository<Keyword, String>{

	List<Keyword> findByKeywd(String keywd);

}
