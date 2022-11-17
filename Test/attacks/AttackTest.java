package attacks;

import attacks.bug.FirstImpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.Pokemon;
import pokemons.SmallPokemon;

import java.util.ArrayList;
import java.util.List;

public abstract class AttackTest {

    protected List<Pokemon> pokemon = new ArrayList<>();
    protected List<Pokemon> enemyPokemon = new ArrayList<>();

    @BeforeEach
    abstract protected void setUp();

}

