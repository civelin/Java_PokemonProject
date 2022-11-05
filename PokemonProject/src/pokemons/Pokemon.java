package pokemons;
import attacks.*;
import java.util.List;

public abstract class Pokemon {
    // fields
    protected String name;
    protected List<String> types;


    // defaultHp is package private which means that it cannot be seen from the other packages
    static double defaultHp = 100;
    protected double hp;

    // defaultAttackPoints is package private
    static double defaultAttackPoints = 25;
    protected double attackPoints;

    // defaultDefencePoints is package private
    static double defaultDefencePoints = 50;
    protected double defencePoints = 50;
    protected List<PokemonAttack> attacks;
    protected boolean isPokemonFighting = false;

    // methods
    public boolean isPokemonDead() {
        return this.hp <= 0 ? true : false;
    }

    public abstract void revivePokemon();


    // getters & setters

}
