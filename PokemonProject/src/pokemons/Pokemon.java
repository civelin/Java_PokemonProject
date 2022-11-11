package pokemons;

import attacks.*;

import java.util.Arrays;
import java.util.List;

public abstract class Pokemon {
    // fields
    protected String name;
    protected List<String> types;


    // defaultHp is package private which means that it cannot be seen from the other packages
    static double defaultHp = 100;
    protected double hp;

    // defaultAttackPoints is package private
    static double defaultAttackPoints = 15;
    protected double attackPoints;

    // defaultDefencePoints is package private
    static double defaultDefencePoints = 50;
    protected double defencePoints = 50;
    protected PokemonAttack[] attacks = new PokemonAttack[2];
    protected boolean isPokemonFighting = false;

    // methods
    public boolean isPokemonDead() {
        return this.hp <= 0 ? true : false;
    }

    public abstract void revivePokemon();


    // getters & setters

    public static double getDefaultHp() {
        return defaultHp;
    }

    public static void setDefaultHp(double defaultHp) {
        Pokemon.defaultHp = defaultHp;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public static double getDefaultAttackPoints() {
        return defaultAttackPoints;
    }

    public static void setDefaultAttackPoints(double defaultAttackPoints) {
        Pokemon.defaultAttackPoints = defaultAttackPoints;
    }

    public double getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public static double getDefaultDefencePoints() {
        return defaultDefencePoints;
    }

    public static void setDefaultDefencePoints(double defaultDefencePoints) {
        Pokemon.defaultDefencePoints = defaultDefencePoints;
    }

    public double getDefencePoints() {
        return defencePoints;
    }

    public String getName() {
        return name;
    }

    public void setDefencePoints(double defencePoints) {
        this.defencePoints = defencePoints;
    }

    public List<String> getTypes() {
        return types;
    }

    public PokemonAttack[] getAttacks() {
        return attacks;
    }

    abstract public double returnInitialHP();

    abstract public double returnInitialAttackPoints();

    abstract public double returnInitialDefencePoints();

    public void addAttackToPokemon(PokemonAttack attack, int index) {
        if (attacks[index] == null) {
            attacks[index] = attack;
        }
    }

    public boolean isThereAttackOnConcreteIndex(int index) {
        return attacks[index] != null ? true : false;
    }

    public void printAttacks(){
        System.out.println("-> " + this.name + "'s attacks:");
        for (PokemonAttack attack: this.attacks) {
            attack.showDescription();
        }
    }
}
