package com.pokedex.pokedex.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokedex.pokedex.model.CaughtPokemon;
import com.pokedex.pokedex.repository.CaughtPokemonRepository;

@Service
public class CaughtPokemonServiceImpl implements CaughtPokemonService {

    @Autowired
    private CaughtPokemonRepository caughtPokemonRepository;

    @Override
    public void catchPokemon(CaughtPokemon caughtPokemon) {
        caughtPokemonRepository.save(caughtPokemon);

    }

    @Override
    public void lousePokemon(int id) {

        if (!caughtPokemonRepository.existsById(id)) {
            throw new RuntimeException("Pokemon hittades inte med id:" + id);
        }
        caughtPokemonRepository.deleteById(id);
        
    }

    @Override
    public void createNote(String note, int id) {
        // Hämta Pokemon med det givna id:t
        CaughtPokemon pokemon = caughtPokemonRepository.findById(id)
                .orElse(null);
        // Sätt den nya anteckning
        pokemon.setNote(note);
        caughtPokemonRepository.save(pokemon);
    }

    @Override
    public void updateNote(String note, int id) {
        // Hämta pokemon med givna id:t
        CaughtPokemon pokemon = caughtPokemonRepository.findById(id)
                .orElse(null);

        if (pokemon.getNote() == null) {
            throw new RuntimeException("Ingen skapad notering finns att uppdatera med det angivna id:t");
        }
        // sätt notering
        pokemon.setNote(note);
        caughtPokemonRepository.save(pokemon);
    }

    @Override
    public void deleteNote(int id) {
        // Hämta pokemon med givna id:t
        CaughtPokemon pokemon = caughtPokemonRepository.findById(id)
                .orElse(null);

        if (pokemon.getNote() == null) {

            throw new RuntimeException("Ingen skapad notering finns att radera med det angivna id:t");
        }
        pokemon.setNote(null);
        caughtPokemonRepository.save(pokemon);
    }

    @Override
    public CaughtPokemon getCaughtPokemon(int id){
       return caughtPokemonRepository.findById(id)
       .orElseThrow(() -> new RuntimeException("Pokemon hittades inte med id:" + id));
    }

    @Override
    public Collection<CaughtPokemon> getAllCaughtPokemon(){
        return (Collection<CaughtPokemon>) caughtPokemonRepository.findAll();
    
    }

}
