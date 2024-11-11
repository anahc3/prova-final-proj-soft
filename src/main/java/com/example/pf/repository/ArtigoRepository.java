package com.example.pf.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.pf.model.Artigo;

@Repository
public interface ArtigoRepository extends MongoRepository<Artigo, String> {
}
