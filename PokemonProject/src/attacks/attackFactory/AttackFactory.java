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
import java.util.Map;

public class AttackFactory {
    private static List<PokemonAttack> bugAttacks = fillBugAttacks();
    private static List<PokemonAttack> electricAttacks = fillElectricAttacks();
    private static List<PokemonAttack> fireAttacks = fillFireAttacks();
    private static List<PokemonAttack> grassAttacks = fillGrassAttacks();
    private static List<PokemonAttack> normalAttacks = fillNormalAttacks();
    private static HashMap<String, List<PokemonAttack>> allAttacks = fillAllAttacks();

    //     fill attacks
    private static HashMap<String, List<PokemonAttack>> fillAllAttacks() {

        HashMap<String, List<PokemonAttack>> attacks = new HashMap<>();
        attacks.put("bug", bugAttacks);
        attacks.put("electric", electricAttacks);
        attacks.put("fire", fireAttacks);
        attacks.put("grass", grassAttacks);
        attacks.put("normal", normalAttacks);

        return attacks;
    }

    // checks if newAttack.getName() has duplicates
    private static boolean contains(List<PokemonAttack> attacks, PokemonAttack newAttack) {
        List<PokemonAttack> duplicates = attacks
                .stream()
                .filter(attack -> attack.getName().equals(newAttack.getName()))
                .toList();
        return duplicates.size() > 0 ? true : false;
    }


    //    -> BUG
    // method that returns all current bug attacks
    private static List<PokemonAttack> fillBugAttacks() {
        List<PokemonAttack> bugAttacks = new ArrayList<>();
        bugAttacks.add(new FirstImpression());
        bugAttacks.add(new LeechLife());
        return bugAttacks;
    }

    // method that provides adding a new attack to bug attacks
    public static List<PokemonAttack> addToBugAttacks(PokemonAttack attack) {
        if (attack.getType().equals("bug") && !contains(bugAttacks, attack)) {
            bugAttacks.add(attack);
        }
        return bugAttacks;
    }


    // -> ELECTRIC
    // method that returns all current electric attacks
    private static List<PokemonAttack> fillElectricAttacks() {
        List<PokemonAttack> electricAttacks = new ArrayList<>();
        electricAttacks.add(new MagneticFlux());
        electricAttacks.add(new Spark());
        return electricAttacks;
    }

    // method that provides adding a new attack to electric attacks
    public static List<PokemonAttack> addToElectricAttacks(PokemonAttack attack) {
        if (attack.getType().equals("electric") && !contains(electricAttacks, attack)) {
            electricAttacks.add(attack);
        }
        return electricAttacks;
    }


    // -> FIRE
    // method that returns all current fire attacks
    private static List<PokemonAttack> fillFireAttacks() {
        List<PokemonAttack> fireAttacks = new ArrayList<>();
        fireAttacks.add(new BlazeKick());
        fireAttacks.add(new BurningJealously());
        return fireAttacks;
    }

    // method that provides adding a new attack to fire attacks
    public static List<PokemonAttack> addToFireAttacks(PokemonAttack attack) {
        if (attack.getType().equals("fire") && !contains(fireAttacks, attack)) {
            fireAttacks.add(attack);
        }
        return fireAttacks;
    }


    // -> GRASS
    // method that returns all current grass attacks
    private static List<PokemonAttack> fillGrassAttacks() {
        List<PokemonAttack> grassAttacks = new ArrayList<>();
        grassAttacks.add(new CottonGuard());
        grassAttacks.add(new HornLeech());
        return grassAttacks;
    }

    // method that provides adding a new attack to grass attacks
    public static List<PokemonAttack> addToGrassAttacks(PokemonAttack attack) {
        if (attack.getType().equals("grass") && !contains(grassAttacks, attack)) {
            grassAttacks.add(attack);
        }
        return grassAttacks;
    }


    // -> NORMAL
    // method that returns all current normal attacks
    private static List<PokemonAttack> fillNormalAttacks() {
        List<PokemonAttack> normalAttacks = new ArrayList<>();
        normalAttacks.add(new Leer());
        normalAttacks.add(new MegaPunch());
        return normalAttacks;
    }

    // method that provides adding a new attack to grass attacks
    public static List<PokemonAttack> addToNormalAttacks(PokemonAttack attack) {
        if (attack.getType().equals("normal") && !contains(normalAttacks, attack)) {
            normalAttacks.add(attack);
        }
        return normalAttacks;
    }

    // getters
    public static HashMap<String, List<PokemonAttack>> getAllAttacks() {
        return allAttacks;
    }
}
