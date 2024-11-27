package player;

public class GodPlayer implements Player {
    private int lifes = 1;

    @Override
    public int getLifes() {
        return lifes;
    }

    @Override
    public void decreaseLife() {
        if (lifes > 0) lifes--;
    }
}