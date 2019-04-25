package com.loggerapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@GetMapping("/api")
public class PessoaController {
	
	@Autowired
	PessoaRepository repository;
	
	@PostMapping("/add")
	public Pessoa addPessoa(@RequestBody Pessoa pessoa ){
		return repository.save(Pessoa);
	}
	
	@GetMapping("/all")
	public List<Pessoa> getPessoas(){
		 Iterator<Pessoa> iterator= repository.findAll().iterator();
		 List<Pessoa> pessoas=new ArrayList<Pessoa>();
		 while(iterator.hasNext()){
			 pessoas.add(iterator.next());
		 }
		 return pessoas;
	}
	

	@GetMapping("/{id}")
	public Optional<Pessoa> getPessoa(@PathVariable Integer id){
		return repository.findById(id);
	}
	
	
	@PutMapping("/{id}")
	   public Pessoa updatePessoa(@PathVariable Integer id,@RequestBody Pessoa pessoa){
		   Optional<Pessoa> std= repository.findById(id);
		   if(std.isPresent()){
			   Pessoa s=std.get();
			   s.setName(pessoa.getName());
		   return repository.save(s);
		   }
		   else
			   return null;
	   }
	
	@DeleteMapping("/{id}")
	   public String deletePessoa(@PathVariable Integer id){
		  repository.deleteById(id);
		  return "Document Deleted";
	   }

	


		

}
