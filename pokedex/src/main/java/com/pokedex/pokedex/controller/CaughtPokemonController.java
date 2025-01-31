package com.pokedex.pokedex.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokedex.pokedex.model.CaughtPokemon;
import com.pokedex.pokedex.service.CaughtPokemonService;

@RestController
@RequestMapping("/api/pokemon") // Bas-URL för alla endpoints
@CrossOrigin(origins = "http://127.0.0.1:5500")
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

    @PostMapping
    public void catchPokemon(@RequestBody CaughtPokemon pokemon ){
        caughtPokemonService.catchPokemon(pokemon);
        System.out.println("catched pokemon" + pokemon);
    }

    @DeleteMapping("/{id}")
    public void lousePokemon(@PathVariable int id){
        caughtPokemonService.lousePokemon(id);
    }


    @PostMapping("/{id}/note")
    public void createNote(@PathVariable int id, @RequestBody String note) {
        caughtPokemonService.createNote(note, id);
        System.out.println("Notering skapas: " + note);
    }

    @PatchMapping("/{id}/note")
    public void updateNote(@PathVariable int id, @RequestBody String note){
        caughtPokemonService.updateNote(note, id);
    }

    @DeleteMapping("{id}/note")
    public void deleteNote(@PathVariable int id){
        caughtPokemonService.deleteNote(id);
    }



}
