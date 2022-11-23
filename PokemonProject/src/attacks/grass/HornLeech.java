package attacks.grass;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import users.User;

public class HornLeech extends PokemonAttack {
    public HornLeech() {
        this.name = "HornLeech";
        this.type = "grass";
        this.description = "Horn Leech attack increases pokemon's hp up to 20 points if it's under 20 points.";
    }

    // Increase hp up to 20 points if it's under 20 points
    @Override
    public double attack(User user, User enemyUser) {
        Pokemon userPokemon = user.getCurrentPokemonForBattle();
        if (userPokemon.getHp() < 20) {
            userPokemon.setHp(20);
        }

        System.out.println("\u2694 " + userPokemon.getName() + " hp after the attack ---> " + userPokemon.getHp());
        return userPokemon.getHp();
    }
}
