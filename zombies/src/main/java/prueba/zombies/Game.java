package prueba.zombies;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private Set<Survivor> survivors;

    public Game() {
        survivors = new HashSet<>();
    }

    public void addSurvivor(Survivor survivor) {
        if (survivors.stream().anyMatch(s -> s.getName().equals(survivor.getName()))) {
            throw new  IllegalArgumentException("Survivor names must be unique");
        }
        survivors.add(survivor);
    }

    public int getServiorCount() {
        return survivors.size();
    }

    public boolean isGameOver() {
        return survivors.stream().allMatch(survivor -> !survivor.isAlive());
    }
}
