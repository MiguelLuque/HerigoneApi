package com.maik.ApiPostgresTemplate.Domain.repository;

import com.maik.ApiPostgresTemplate.Domain.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HerigoneRepository extends JpaRepository<Word, Long> {

    @Query(value = "select * from dictionary where word like ?1 ORDER BY CHAR_LENGTH(word) asc limit 5;", nativeQuery = true)
    List<Word> findHerigoneWords(String herigoneCode);

}