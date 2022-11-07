package attacks.grass;

import pokemons.Pokemon;

public class HornLeech {
    // Increase hp up to 25 points if it's under 25 points

    public double hornLeech(Pokemon userPokemon){
        if(userPokemon.getHp() < 25){
            userPokemon.setHp(25);
        }
        System.out.println(userPokemon.getName() + " hp after the attack is " + userPokemon.getHp());
        return userPokemon.getHp();
    }

}
