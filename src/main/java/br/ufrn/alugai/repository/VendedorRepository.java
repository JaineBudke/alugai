package br.ufrn.alugai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.alugai.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

}