package br.ufrn.alugai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufrn.alugai.model.Anuncio;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer>  {

	@Query("select u from Anuncio u where u.id = ?1")
	Anuncio findById(int id);

	
	
}
