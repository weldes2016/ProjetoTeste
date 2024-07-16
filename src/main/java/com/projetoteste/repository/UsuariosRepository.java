package com.projetoteste.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projetoteste.model.Usuarios;


@Repository
public interface UsuariosRepository extends CrudRepository<Usuarios, Long> {
	Usuarios findByNome(boolean b);

}
