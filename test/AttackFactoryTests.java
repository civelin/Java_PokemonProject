import attacks.PokemonAttack;
import attacks.attackFactory.AttackFactory;
import attacks.bug.FirstImpression;
import attacks.electric.MagneticFlux;
import attacks.fire.BurningJealously;
import attacks.grass.CottonGuard;
import attacks.normal.MegaPunch;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class AttackFactoryTests {

    private PokemonAttack bugAttackFirstImpression = new FirstImpression();

    private PokemonAttack electricAttackMagneticFlux = new MagneticFlux();
    private PokemonAttack fireAttackBurningJealously = new BurningJealously();

    private PokemonAttack grassAttackCottonGuard = new CottonGuard();

    private PokemonAttack normalAttackMegaPunch = new MegaPunch();


    @Test
    public void testAddToBugAttacks(){
        assertFalse(AttackFactory.addToBugAttacks(bugAttackFirstImpression));
        assertFalse(AttackFactory.addToBugAttacks(fireAttackBurningJealously));
    }

    @Test
    public void testAddToElectricAttacks(){
        assertFalse(AttackFactory.addToFireAttacks(normalAttackMegaPunch));
        assertFalse(AttackFactory.addToBugAttacks(electricAttackMagneticFlux));
    }

    @Test
    public void testAddToFireAttacks(){
        assertFalse(AttackFactory.addToFireAttacks(bugAttackFirstImpression));
        assertFalse(AttackFactory.addToBugAttacks(fireAttackBurningJealously));
    }

    @Test
    public void testAddToGrassAttacks(){
        assertFalse(AttackFactory.addToFireAttacks(electricAttackMagneticFlux));
        assertFalse(AttackFactory.addToBugAttacks(grassAttackCottonGuard));
    }
    @Test
    public void testAddToNormalAttacks(){
        assertFalse(AttackFactory.addToFireAttacks(normalAttackMegaPunch));
        assertFalse(AttackFactory.addToBugAttacks(grassAttackCottonGuard));
    }

}
