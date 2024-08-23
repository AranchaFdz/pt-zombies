package prueba.zombies;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SurvivorTest {

    private Survivor survivor;

    @BeforeEach
    void setUp() {
        survivor = new SurvivorBuilder().withName("Manu").build();
    }
    
    @Test
    void testSurvivorInitalization() {
        assertEquals("Manu", survivor.getName());
        assertEquals(0, survivor.getWounds());
        equals(survivor.isAlive());
    }

    @Test
    void testSurvivorReceivesWoundsAndDies() {
        survivor.receiveWound();
        assertEquals(1, survivor.getWounds());
        assertTrue(survivor.isAlive());

        survivor.receiveWound();
        assertEquals(2, survivor.getWounds());
        assertFalse(survivor.isAlive());

        survivor.receiveWound();
        assertEquals(2, survivor.getWounds());
        assertFalse(survivor.isAlive());

    }

    @Test
    void testSurvivorActionsPerTurn() {
        assertEquals(3, survivor.getActionsPerTurn());
    }

}
