package com.projetoteste.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projetoteste.model.Usuarios;
import com.projetoteste.repository.UsuariosRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UsuariosService {
	
	private final UsuariosRepository usuariosRepository;
	
	public UsuariosService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}

	public UsuariosRepository getUsuariosRepository() {
		return usuariosRepository;
	}
	
	 
    @PostConstruct
    public void populateRedis() {
        List<Usuarios> usuariosList = Arrays.asList(
            new Usuarios("1", "Weldes", "weldes@example.com", "1234"),
            new Usuarios("2", "John", "john@example.com", "1234"),
            new Usuarios("3", "Jane", "jane@example.com", "1234"),
            new Usuarios("4", "Alice", "alice@example.com", "1234"),
            new Usuarios("5", "Bob", "bob@example.com","1234")
        );

        for (Usuarios usuario : usuariosList) {
            Usuarios savedUsuario = usuariosRepository.save(usuario);
            
            if (savedUsuario != null && savedUsuario.getId() != null) {
                emitirMensagem(savedUsuario);
                System.out.println("Registro inserido com sucesso. ID: " + savedUsuario.getId());
            } else {
                System.out.println("Falha ao inserir o registro: " + usuario);
            }
        }
    }
	
	 private void emitirMensagem(Usuarios usuario) {
	        System.out.println("Registro inserido no banco de dados: " + usuario.getNome() + " ID: "+usuario.getId());
	        // Aqui você pode substituir o println com o código para enviar uma mensagem, se necessário
	    }
}
