package Models;
import java.awt.Graphics;

public class DestroyedState implements TankState {
    @Override
    public void move(Tank tank) {
        // Cannot move when destroyed
    }

    @Override
    public void fire(Tank tank) {
        // Cannot fire when destroyed
    }

    @Override
    public void handleDamage(Tank tank, int damage) {
        // Cannot take more damage when destroyed
    }

    @Override
    public void draw(Graphics g, Tank tank) {
        // Tank is not drawn when destroyed
        // Could add explosion animation here
    }

    @Override
    public void handlePowerUp(Tank tank) {
        // Cannot power up when destroyed
    }
} 