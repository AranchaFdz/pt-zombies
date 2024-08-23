package prueba.zombies;

public class Survivor {
    private String name;
    private int wounds;
    private boolean alive;
    private static final int MAX_WOUNDS =2;
    private static final int ACTIONS_PER_TURN = 3;

    public Survivor(String name, int wounds, boolean alive) {
        this.name = name;
        this.wounds = wounds;
        this.alive = alive;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setWounds(int wounds) {
        this.wounds = wounds;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public static int getMaxWounds() {
        return MAX_WOUNDS;
    }

    public void receiveWound() {
        if (alive && wounds < MAX_WOUNDS) {
            wounds++;
            if (wounds >= MAX_WOUNDS) {
                alive = false;
            }
        }
    }

    public int getActionsPerTurn() {
        return ACTIONS_PER_TURN;
    }
}
