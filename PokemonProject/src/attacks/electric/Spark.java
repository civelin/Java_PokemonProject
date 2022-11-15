package attacks.electric;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;
import java.util.Random;

public class Spark extends PokemonAttack {

    public Spark() {
        this.name = "Spark";
        this.type = "electric";
        this.description = "Spark attack has equal chances to hit opponent's hp or miss the target.";
    }

    public double attack(List<Pokemon> userCurrentPokemons, List<Pokemon> enemyCurrentPokemons) {
        Pokemon userPokemon = (Pokemon) userCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];
        Pokemon enemyPokemon = (Pokemon) enemyCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];

        Random randomChance = new Random();
        int critChance = randomChance.nextInt(2); //return 0 or 1

        double finalAttackPower = critChance * ((userPokemon.getAttackPoints() + this.attackPower) * 1.1 - enemyPokemon.getDefencePoints() * 0.3);
        if (finalAttackPower < 0) {
            finalAttackPower = this.attackPower;
        }
        enemyPokemon.setHp(enemyPokemon.getHp() - finalAttackPower);
        if (critChance == 0) {
            System.out.println(userPokemon.getName() + " missed the target!");
        } else {
            System.out.println(userPokemon.getName() + " has attacked " + enemyPokemon.getName());
            System.out.println(enemyPokemon.getName() + " new hp ----> " + enemyPokemon.getHp());

        }
        return critChance;
    }
}
