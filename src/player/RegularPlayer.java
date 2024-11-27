package player;

public class RegularPlayer implements Player {
    private int lifes = 8;

    @Override
    public int getLifes() {
        return lifes;
    }

    @Override
    public void decreaseLife() {
        if (lifes > 0) lifes--;
    }
}
