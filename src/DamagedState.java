import java.awt.Graphics;

public class DamagedState implements TankState {
    @Override
    public void move(Tank tank) {
        // Reduced movement speed when damaged
        Tank.speedX = 4;
        Tank.speedY = 4;
    }

    @Override
    public void fire(Tank tank) {
        // Reduced fire rate when damaged
        if (tank.isGood()) {
            tank.rate = 1;
        }
    }

    @Override
    public void handleDamage(Tank tank, int damage) {
        int currentLife = tank.getLife();
        tank.setLife(currentLife - damage);
        
        if (tank.getLife() <= 0) {
            tank.setLive(false);
            tank.setState(new DestroyedState());
        }
    }

    @Override
    public void draw(Graphics g, Tank tank) {
        // Draw damaged tank (using normal images for now)
        tank.draw(g);
    }

    @Override
    public void handlePowerUp(Tank tank) {
        // Return to normal state when powered up
        tank.setState(new NormalState());
    }
} 