package br.ufrn.alugai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufrn.alugai.model.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer> {

	@Query("select u from Imovel u where u.id = ?1")
	Imovel findById(int id);
	
}
