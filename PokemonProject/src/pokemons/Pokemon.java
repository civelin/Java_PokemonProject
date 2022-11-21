package pokemons;

import attacks.*;

import java.io.BufferedReader;
import java.util.List;

public abstract class Pokemon implements InitialPoints, Revivable {
    // fields
    protected String name;
    protected List<String> types;
    final static int defaultHp = 100;
    final static int defaultAttackPoints = 15;
    final static int defaultDefencePoints = 50;
    protected double hp;
    protected double attackPoints;
    protected double defencePoints;

    // each pokemon has two attacks
    protected PokemonAttack[] attacks = new PokemonAttack[2];

    // methods
    public boolean isPokemonDead() {
        return this.hp <= 0;
    }

    public void revivePokemon() {
        this.hp = this.returnInitialHP();
        this.attackPoints = this.returnInitialAttackPoints();
        this.defencePoints = this.returnInitialDefencePoints();
    }

    public void addAttackToPokemon(PokemonAttack attack, int index) {
        if (attacks[index] == null) {
            attacks[index] = attack;
        }
    }

    public boolean isThereAttackOnConcreteIndexAtPokemonAttacks(int index) {
        return attacks[index] != null ? true : false;
    }

    public void printAttacks() {
        System.out.println("-> " + this.name + "'s attacks:");
        for (int i = 0; i <= 1; i++) {
            System.out.println((i + 1) + ". " + this.attacks[i].getDescription());
        }

    }

    // getters & setters

    public String getName() {
        return name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public double getDefencePoints() {
        return defencePoints;
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

}
