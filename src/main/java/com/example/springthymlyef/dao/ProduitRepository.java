package com.example.springthymlyef.dao;

import com.example.springthymlyef.model.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
