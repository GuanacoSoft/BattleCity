import java.awt.Graphics;

public class PoweredUpState implements TankState {
    @Override
    public void move(Tank tank) {
        // Increased movement speed
        Tank.speedX = 8;
        Tank.speedY = 8;
    }

    @Override
    public void fire(Tank tank) {
        // Increased fire rate
        if (tank.isGood()) {
            tank.rate = 2;
        }
    }

    @Override
    public void handleDamage(Tank tank, int damage) {
        int currentLife = tank.getLife();
        // Take less damage in powered up state
        tank.setLife(currentLife - (damage / 2));
        
        if (tank.getLife() <= 50) {
            tank.setState(new NormalState());
        } else if (tank.getLife() <= 0) {
            tank.setLive(false);
            tank.setState(new DestroyedState());
        }
    }

    @Override
    public void draw(Graphics g, Tank tank) {
        // Use powered up tank images (already using player 1 or 2 images)
        tank.draw(g);
    }

    @Override
    public void handlePowerUp(Tank tank) {
        // Already in powered up state, maybe extend duration
    }
} 