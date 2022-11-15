package attacks.normal;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;
import java.util.Random;

public class MegaPunch extends PokemonAttack {

    public MegaPunch() {
        this.name = "MegaPunch";
        this.type = "normal";
        this.attackPower = 1.4 * super.attackPower;
        this.description = "Mega punch attack deals damage to the opponent's pokemon.";
    }

    public double attack(List<Pokemon> userCurrentPokemons, List<Pokemon> enemyCurrentPokemons) {
        Pokemon userPokemon = (Pokemon) userCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];
        Pokemon enemyPokemon = (Pokemon) enemyCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];


        // High critical hit ratio
        Random rnd = new Random();
        int critChance = rnd.nextInt(3)+1;
        double finalInflictedDmg;
        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints() * 0.3;
        double pokemonAttackPower = userPokemon.getAttackPoints();
        finalInflictedDmg = (pokemonAttackPower + ((this.attackPower * critChance)) - dmgReductionAccordingToEnemyPokemonDefencePoints);
        enemyPokemon.setHp(enemyPokemon.getHp() - finalInflictedDmg);

        System.out.println(userPokemon.getName() + " has attacked " + enemyPokemon.getName());
        System.out.println(enemyPokemon.getName() + " new hp ----> " + enemyPokemon.getHp());
        return finalInflictedDmg;


    }


}
