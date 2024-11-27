package player;

public class ChildPlayer implements Player {
    private int lifes = 20;

    @Override
    public int getLifes() {
        return lifes;
    }

    @Override
    public void decreaseLife() {
        if (lifes > 0) lifes--;
    }
}
