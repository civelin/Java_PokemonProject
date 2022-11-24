package pokemons;

import attacks.*;

import java.util.List;
import java.util.Objects;

public abstract class Pokemon implements InitialPoints, Revivable {

    // fields
    protected String name;
    protected List<String> types;
    final static int defaultHp = 100;
    final static int defaultAttackPoints = 15;
    final static int defaultDefencePoints = 50;

    protected int hp;
    protected int attackPoints;
    protected int defencePoints;

    // each pokemon has two attacks
    protected PokemonAttack[] attacks = new PokemonAttack[2];

    // methods
    public boolean isPokemonDead() {
        return this.hp <= 0;
    }

    public void resetInitialPointsOfPokemon() {
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
        return attacks[index] != null;
    }

    public void printAttacks() {
        System.out.println("-> " + this.name + "'s attacks:");
        for (int i = 0; i <= 1; i++) {
            System.out.println((i + 1) + ". " + this.attacks[i].getDescription());
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(name, pokemon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // getters & setters

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefencePoints() {
        return defencePoints;
    }

    public void setDefencePoints(int defencePoints) {

        this.defencePoints = defencePoints;

    }

    public List<String> getTypes() {
        return types;
    }

    public PokemonAttack[] getAttacks() {
        return attacks;
    }

}
