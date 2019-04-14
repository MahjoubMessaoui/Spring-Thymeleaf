package com.example.springthymlyef.controller;

import com.example.springthymlyef.dao.ProduitRepository;
import com.example.springthymlyef.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;


    @GetMapping("/index")
    public String chercher(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "motCle", defaultValue = "") String mc){
        Page<Produit> PageProduits =
                produitRepository.findAll(PageRequest.of(page,5 ));
        model.addAttribute("listeproduit", PageProduits.getContent());
        model.addAttribute("pages", new int[PageProduits.getTotalPages()]);
        model.addAttribute("currentpage", page);
        return "produits";
    }


    @GetMapping("/remove")
    public String delete(Long id) {

        produitRepository.deleteById(id);

        return "redirect:/produit/index";
    }
/*
    @PostMapping("/add")
    public String addproduit(Produit produit) {
        produitRepository.saveAndFlush(produit);
        return "addproduit";
    }*/
    @PostMapping("/add")
   public String addproduit(){

        return "addproduit";
    }

}
