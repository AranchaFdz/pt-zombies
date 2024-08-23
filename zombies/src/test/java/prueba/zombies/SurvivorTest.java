package prueba.zombies;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SurvivorTest {

    private Survivor survivor;
    private Equipment bat;
    private Equipment gun;
    private Equipment katana;
    private Equipment waterBottle;
    private Equipment molotov;

    @BeforeEach
    void setUp() {
        survivor = new Survivor("Manu");
        bat = new Equipment("Bate de béisbol");
        gun = new Equipment("Pistola");
        katana = new Equipment("Katana");
        waterBottle = new Equipment("Botella de agua");
        molotov = new Equipment("Molotov");

        survivor.addEquipment(bat);
        survivor.addEquipment(gun);
        survivor.addEquipment(katana);
        survivor.addEquipment(waterBottle);
        survivor.addEquipment(molotov);
    }
    
    @Test
    void testSurvivorInitalization() {
        assertEquals("Manu", survivor.getName());
        assertEquals(0, survivor.getWounds());
        assertTrue(survivor.isAlive());

        assertEquals(2, survivor.getInHand().size());
        assertTrue(survivor.getInHand().contains(bat));
        assertTrue(survivor.getInHand().contains(gun));
        

        assertEquals(3, survivor.getInReserve().size());
        assertTrue(survivor.getInReserve().contains(katana));
        assertTrue(survivor.getInReserve().contains(waterBottle));
        assertTrue(survivor.getInReserve().contains(molotov));
        
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

    @Test
    void testAddEquipment() {
        
        Equipment newEquipment = new Equipment("New Equipment");
        survivor.addEquipment(newEquipment);

        assertEquals(2, survivor.getInHand().size());
        assertEquals(3, survivor.getInReserve().size());
        assertTrue(survivor.getInReserve().contains(newEquipment));
    }

    @Test
    void testSurvivorRecivesWoundsAndLosesEquipment() {

        assertEquals(0, survivor.getWounds());
        assertTrue(survivor.isAlive());

        survivor.receiveWound();
        assertEquals(1, survivor.getWounds());
        assertTrue(survivor.isAlive());

        assertEquals(4, survivor.getInHand().size() +survivor.getInReserve().size());

        survivor.receiveWound();
        assertEquals(2, survivor.getWounds());
        assertFalse(survivor.isAlive());

        assertEquals(3, survivor.getInHand().size() + survivor.getInReserve().size());

    }

}
