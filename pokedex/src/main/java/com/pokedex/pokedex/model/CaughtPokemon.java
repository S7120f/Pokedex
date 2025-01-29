package com.pokedex.pokedex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CaughtPokemon {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pokemonId;
    private String note;

    protected CaughtPokemon() {}

    public CaughtPokemon(int pokemon_id, String note) {
        this.pokemonId = pokemon_id;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemon_id) {
        this.pokemonId = pokemon_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    
    
}
