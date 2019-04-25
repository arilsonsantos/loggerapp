package com.loggerapp;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "pessoa", type = "default")
public class Pessoa {

	@Id
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Pessoa(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Pessoa(){}
	
}
