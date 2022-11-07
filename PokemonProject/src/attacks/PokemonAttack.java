package attacks;

public abstract class PokemonAttack  {
    //    TODO: create field description
    protected String type;
    protected double attackPower = 10;

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
}
