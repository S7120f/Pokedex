package com.pokedex.pokedex.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokedex.pokedex.model.CaughtPokemon;
import com.pokedex.pokedex.service.CaughtPokemonService;

@RestController
@RequestMapping("/api/pokemon") // Bas-URL för alla endpoints
public class CaughtPokemonController {
    @Autowired
    private CaughtPokemonService caughtPokemonService;

    
    public CaughtPokemonController(CaughtPokemonService caughtPokemonService) {
        this.caughtPokemonService = caughtPokemonService;
    }

    @GetMapping
    public Collection<CaughtPokemon> getAllPokemon(){
        return caughtPokemonService.getAllCaughtPokemon();
    }

    // Hämta med specifikt id
    @GetMapping("/{id}")
    public CaughtPokemon getCaughtPokemon(@PathVariable int id){
        return caughtPokemonService.getCaughtPokemon(id);
    }
    


    
    


}
