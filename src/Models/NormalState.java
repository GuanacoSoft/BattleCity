package Models;
import java.awt.Graphics;

public class NormalState implements TankState {


    @Override
    public void loadImages(Tank tank) {}

    
    @Override
    public void move(Tank tank) {
        // Normal movement speed
        Tank.speedX = 6;
        Tank.speedY = 6;
    }

    @Override
    public void fire(Tank tank) {
        // Normal fire rate
        if (tank.isGood()) {
            tank.rate = 1;
        }
    }

    @Override
    public void handleDamage(Tank tank, int damage) {
        int currentLife = tank.getLife();
        tank.setLife(currentLife - damage);
        
        if (tank.getLife() <= 50) {
            tank.setState(new DamagedState());
        } else if (tank.getLife() <= 0) {
            tank.setLive(false);
            tank.setState(new DestroyedState());
        }
    }


    @Override
    public void handlePowerUp(Tank tank) {
        tank.setState(new PoweredUpState());
    }
} 