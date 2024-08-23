package prueba.zombies;

public class SurvivorBuilder {
    private String name;
    private int wounds = 0;
    private boolean alive = true;

    public SurvivorBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public SurvivorBuilder withWounds(int wounds) {
        this.wounds = wounds;
        return this;
    }

    public SurvivorBuilder isAlive(boolean alive) {
        this.alive = alive;
        return this;
    }

    public Survivor build() {
        return new Survivor(name, wounds, alive);
    }
}
