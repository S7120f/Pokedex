package com.pokedex.pokedex.service;

import java.util.Collection;

import com.pokedex.pokedex.model.CaughtPokemon;

public interface CaughtPokemonService {
    public  void catchPokemon(CaughtPokemon caughtPokemon);
    public  void lousePokemon(int id);
    public  void createNote(String note, int id);
    public  void updateNote(String note, int id);
    public  void deleteNote(int id);
    public  CaughtPokemon getCaughtPokemon(int id);
    public  Collection<CaughtPokemon> getAllCaughtPokemon();
    
}
