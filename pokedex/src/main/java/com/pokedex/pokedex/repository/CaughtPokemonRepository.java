package com.pokedex.pokedex.repository;

import org.springframework.data.repository.CrudRepository;

import com.pokedex.pokedex.model.CaughtPokemon;


public interface CaughtPokemonRepository extends CrudRepository<CaughtPokemon, Integer> {

    
}
