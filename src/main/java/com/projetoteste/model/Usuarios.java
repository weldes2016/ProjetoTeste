package com.projetoteste.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Usuarios")
public class Usuarios {
	@Id
	private String id;
	private String nome;
	private String email;
	private String password;

	public Usuarios(String id, String nome, String email, String password) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuarios{" + "id='" + id + '\'' + ", nome='" + nome + '\'' + ", email=" + email + ", password="+password+'}';
	}

}
