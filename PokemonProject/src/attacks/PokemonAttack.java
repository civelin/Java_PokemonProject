package attacks;


public abstract class PokemonAttack {

    // fields
    protected String name;
    protected String type;
    protected String description;
    protected double attackPower = 10;

    // methods
    public void showDescription(){
        System.out.println("    -> " + this.description);
    }

    public String getName() {
        return name;
    }

    // getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public boolean compare(PokemonAttack attack){
        return this.getName().equals(attack.getName());
    }

}
