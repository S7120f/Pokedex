# Pokédex Backend API

Ett Spring Boot-baserat REST API för att hantera fångade Pokémon och deras anteckningar.

## Förutsättningar

- Java 17 eller senare
- Maven
- MySQL (konfigurerad att köra på port 8889)
- En MySQL-databas med namn "pokedexdatabas"

## Installation och konfiguration

1. Klona projektet
2. Skapa en MySQL-databas:
   - Databasnamn: `pokedexdatabas`
   - Användarnamn: `pokedexdatabas`
   - Lösenord: `pokedexdatabas`

3. Kontrollera att MySQL körs på port 8889

4. Starta applikationen: 


API:et kommer att vara tillgängligt på `http://localhost:8080`

## API Endpoints

### Pokémon-hantering
- `GET /api/pokemon` - Hämta alla fångade Pokémon
- `GET /api/pokemon/{id}` - Hämta specifik Pokémon
- `POST /api/pokemon` - Fånga en ny Pokémon
- `DELETE /api/pokemon/{id}` - Släpp en Pokémon

### Antecknings-hantering
- `POST /api/pokemon/{id}/note` - Skapa anteckning
- `PATCH /api/pokemon/{id}/note` - Uppdatera anteckning - nyttjas ej men metoden finns i service klassen och controller, vi kan uppdatera notes genom att bara skriva en ny note så ersätter vi tidigare note. 
- `DELETE /api/pokemon/{id}/note` - Ta bort anteckning

## Databaskonfiguration

Standardkonfigurationen finns i `application.properties`:

properties
spring.datasource.url=jdbc:mysql://localhost:8889/pokedexdatabas
spring.datasource.username=pokedexdatabas
spring.datasource.password=pokedexdatabas
spring.jpa.hibernate.ddl-auto=update

## CORS-konfiguration

API:et är konfigurerat att acceptera anrop från `http://127.0.0.1:5500` för utveckling.
