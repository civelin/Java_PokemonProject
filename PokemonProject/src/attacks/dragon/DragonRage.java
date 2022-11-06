package attacks.dragon;

import attacks.PokemonAttack;

import java.util.Random;

public class DragonRage extends PokemonAttack {

    public DragonRage(){
        this.type = "dragon";
        this.attackPower = 25;
    }
    //always inflicts 25 HP if the attack is successful
    public double dragonRage(){
        Random random = new Random();
        int chanceToHitDragonRage = random.nextInt(2);
        if(chanceToHitDragonRage==0){
            return 0;
        }else {
            return this.attackPower;
        }
    }
}
