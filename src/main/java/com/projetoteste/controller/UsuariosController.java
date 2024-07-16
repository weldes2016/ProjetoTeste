package com.projetoteste.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoteste.model.Usuarios;
import com.projetoteste.repository.UsuariosRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	private final UsuariosRepository usuariosRepository;

	public UsuariosController(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}

	@PostMapping
	public Usuarios addUsuarios(@RequestBody Usuarios usuario) {
		return usuariosRepository.save(usuario);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> getUsuarios(@PathVariable Long id) {
		Optional<Usuarios> usuario = usuariosRepository.findById((id));

		if (usuario != null) {
			System.out.println("Aqui achou o cara: " + usuario.get().getNome());
		} else {
			return ResponseEntity.notFound().build();
		}
		return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping(produces = "application/json")
	public List<Usuarios> getAllUsuarios() {
		return (List<Usuarios>) usuariosRepository.findAll();
	}

	@PutMapping("/{id}")
	public Usuarios updateUsuarios(@PathVariable String id, @RequestBody Usuarios usuariosDetails) {
		System.out.println("Eita");
		Usuarios usuario = usuariosRepository.findById(Long.valueOf(id))
				.orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
		usuario.setNome(usuariosDetails.getNome());
		usuario.setEmail(usuariosDetails.getEmail());
		return usuariosRepository.save(usuario);
	}

	@GetMapping("/crud")
	public String showCrudPage() {
		return "crud";
	}

	@DeleteMapping("/{id}")
	public void deleteUsuarios(@PathVariable String id) {
		usuariosRepository.deleteById(Long.valueOf(id));
	}

	public UsuariosRepository getUsuariosRepository() {
		return usuariosRepository;
	}

}
