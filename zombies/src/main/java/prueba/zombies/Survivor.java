package prueba.zombies;

import java.util.ArrayList;
import java.util.List;

public class Survivor {
    private String name;
    private int wounds;
    private boolean alive;
    private static final int MAX_WOUNDS =2;
    private static final int MAX_EQUIPMENT = 5;
    private List<Equipment> inHand;
    private List<Equipment> inReserve;

    public Survivor(String name) {
        this.name = name;
        this.wounds = 0;
        this.alive = true;
        this.inHand = new ArrayList<>();
        this.inReserve = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getWounds() {
        return wounds;
    }

    public boolean isAlive() {
        return alive;
    }

    public static int getMaxWounds() {
        return MAX_WOUNDS;
    }

    public void receiveWound() {
        if (alive) {
            wounds++;
            if (wounds >= MAX_WOUNDS) {
                alive = false;
            }
            adjustEquipmentCapacity();
        }
    }

    public int getActionsPerTurn() {
        return 3;
    }

    public void addEquipment(Equipment equipment) {
        if (inHand.size() < 2) {
            inHand.add(equipment);
        } else {
            inReserve.add(equipment);
        }
        adjustEquipmentCapacity();
    }

    private void adjustEquipmentCapacity() {
        int capacity = MAX_EQUIPMENT - wounds;
        while (inHand.size() + inReserve.size() > capacity) {
            discardEquipment();
        }
    }

    private void discardEquipment() {
        if (!inReserve.isEmpty()) {
            inReserve.remove(0);
        } else if (!inHand.isEmpty()) {
            inHand.remove(0);
        }
    }

    public List<Equipment> getInHand() {
        return new ArrayList<>(inHand);
    }

    public List<Equipment> getInReserve() {
        return new ArrayList<>(inReserve);
    }
}
