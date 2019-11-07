package br.ufrn.alugai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.alugai.model.Imovel;

@Repository
public interface EnderecoRepository extends JpaRepository<Imovel, Integer>{

}
