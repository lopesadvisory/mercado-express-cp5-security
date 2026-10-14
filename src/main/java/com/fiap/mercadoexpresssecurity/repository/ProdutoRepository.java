package com.fiap.mercadoexpresssecurity.repository;

import com.fiap.mercadoexpresssecurity.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
