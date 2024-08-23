package prueba.zombies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    
    private Game game; 

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void testGameStartsWithNoSurvivors() {
        assertEquals(0, game.getServiorCount());
    }

    @Test
    void testAddSurvivorToGame() {
        Survivor survivor = new Survivor("Manu");
        game.addSurvivor(survivor);
        assertEquals(1, game.getServiorCount());
    }

    @Test
    void testAddMultipleSurvivors() {
        Survivor survivor1 = new Survivor("Manu");
        Survivor survivor2 = new Survivor("Arancha");
        game.addSurvivor(survivor1);
        game.addSurvivor(survivor2);
        assertEquals(2, game.getServiorCount());
    }

    @Test
    void  testSurvivorNameMustBeUnique() {
        Survivor survivor1 = new Survivor("Manu");
        Survivor survivor2 = new Survivor("Manu");
        game.addSurvivor(survivor1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            game.addSurvivor(survivor2);
        });
        assertEquals("Survivor names must be unique", exception.getMessage());
    }

    @Test
    void testGameEndsWhenAllSurvivorsAreDead() {
        Survivor survivor1 = new Survivor("Manu");
        Survivor survivor2 = new Survivor("Arancha");
        game.addSurvivor(survivor1);
        game.addSurvivor(survivor2);

        survivor1.receiveWound();
        survivor1.receiveWound();

        survivor2.receiveWound();
        survivor2.receiveWound();

        assertTrue(game.isGameOver());
    }

    @Test
    void testGameSoesNotEndIfAtLeastOneSurvivorIsAlive() {
        Survivor survivor1 = new Survivor("Manu");
        Survivor survivor2 = new Survivor("Arancha");
        game.addSurvivor(survivor1);
        game.addSurvivor(survivor2);

        survivor1.receiveWound();
        survivor1.receiveWound();

        assertFalse(game.isGameOver());
    }
}
