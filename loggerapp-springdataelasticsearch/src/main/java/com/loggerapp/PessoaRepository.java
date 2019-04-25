package com.loggerapp;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
 interface PessoaRepository extends ElasticsearchRepository<Pessoa, Integer> {

}
