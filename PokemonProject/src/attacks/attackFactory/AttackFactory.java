package attacks.attackFactory;

import attacks.PokemonAttack;
import attacks.bug.FirstImpression;
import attacks.bug.LeechLife;
import attacks.electric.MagneticFlux;
import attacks.electric.Spark;
import attacks.fire.BlazeKick;
import attacks.fire.BurningJealously;
import attacks.grass.CottonGuard;
import attacks.grass.HornLeech;
import attacks.normal.Leer;
import attacks.normal.MegaPunch;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AttackFactory {
    // fields
    private static List<PokemonAttack> bugAttacks = returnBugAttacks();
    private static List<PokemonAttack> electricAttacks = returnElectricAttacks();
    private static List<PokemonAttack> fireAttacks = returnFireAttacks();
    private static List<PokemonAttack> grassAttacks = returnGrassAttacks();
    private static List<PokemonAttack> normalAttacks = returnNormalAttacks();
    private static HashMap<String, List<PokemonAttack>> allAttacks = returnAllAttacks();

    // private constructor
    private AttackFactory() {
    }

    // fill attacks
    private static HashMap<String, List<PokemonAttack>> returnAllAttacks() {

        HashMap<String, List<PokemonAttack>> attacks = new HashMap<>();
        attacks.put("bug", bugAttacks);
        attacks.put("electric", electricAttacks);
        attacks.put("fire", fireAttacks);
        attacks.put("grass", grassAttacks);
        attacks.put("normal", normalAttacks);

        return attacks;
    }

    //    -> BUG
    // method that returns all current bug attacks
    private static List<PokemonAttack> returnBugAttacks() {
        List<PokemonAttack> bugAttacks = new ArrayList<>();
        bugAttacks.add(new FirstImpression());
        bugAttacks.add(new LeechLife());
        return bugAttacks;
    }

    // method that provides adding a new attack to bug attacks
    public static boolean addToBugAttacks(PokemonAttack attack) {
        if (!bugAttacks.contains(attack)) {
            bugAttacks.add(attack);
            return true;
        }
        return false;
    }

    // -> ELECTRIC
    // method that returns all current electric attacks
    private static List<PokemonAttack> returnElectricAttacks() {
        List<PokemonAttack> electricAttacks = new ArrayList<>();
        electricAttacks.add(new MagneticFlux());
        electricAttacks.add(new Spark());
        return electricAttacks;
    }

    // method that provides adding a new attack to electric attacks
    public static boolean addToElectricAttacks(PokemonAttack attack) {
        if (!electricAttacks.contains(attack)) {
            electricAttacks.add(attack);
            return true;
        }
        return false;
    }

    // -> FIRE
    // method that returns all current fire attacks
    private static List<PokemonAttack> returnFireAttacks() {
        List<PokemonAttack> fireAttacks = new ArrayList<>();
        fireAttacks.add(new BlazeKick());
        fireAttacks.add(new BurningJealously());
        return fireAttacks;
    }

    // method that provides adding a new attack to fire attacks
    public static boolean addToFireAttacks(PokemonAttack attack) {
        if (!fireAttacks.contains(attack)) {
            fireAttacks.add(attack);
            return true;
        }
        return false;
    }


    // -> GRASS
    // method that returns all current grass attacks
    private static List<PokemonAttack> returnGrassAttacks() {
        List<PokemonAttack> grassAttacks = new ArrayList<>();
        grassAttacks.add(new CottonGuard());
        grassAttacks.add(new HornLeech());
        return grassAttacks;
    }

    // method that provides adding a new attack to grass attacks
    public static boolean addToGrassAttacks(PokemonAttack attack) {
        if (!grassAttacks.contains(attack)) {
            grassAttacks.add(attack);
            return true;
        }
        return false;
    }

    // -> NORMAL
    // method that returns all current normal attacks
    private static List<PokemonAttack> returnNormalAttacks() {
        List<PokemonAttack> normalAttacks = new ArrayList<>();
        normalAttacks.add(new Leer());
        normalAttacks.add(new MegaPunch());
        return normalAttacks;
    }

    // method that provides adding a new attack to grass attacks
    public static boolean addToNormalAttacks(PokemonAttack attack) {
        if (!normalAttacks.contains(attack)) {
            return true;
        }
        return false;
    }

    // getters
    public static HashMap<String, List<PokemonAttack>> getAllAttacks() {
        return allAttacks;
    }
}
