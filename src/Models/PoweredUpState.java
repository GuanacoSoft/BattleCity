package Models;

import java.awt.*;

public class PoweredUpState implements TankState {

    
    @Override
    public void loadImages(Tank tank) { 

		Tank.tankImags = new Image[] {
				Tank.tk.getImage(BombTank.class.getResource("Images/tankD.gif")),
				Tank.tk.getImage(BombTank.class.getResource("Images/tankU.gif")),
				Tank.tk.getImage(BombTank.class.getResource("Images/tankL.gif")),
				Tank.tk.getImage(BombTank.class.getResource("Images/tankR.gif")), 
				Tank.tk.getImage(BombTank.class.getResource("Images/HtankD2.gif")),
				Tank.tk.getImage(BombTank.class.getResource("Images/HtankU2.gif")),
				Tank.tk.getImage(BombTank.class.getResource("Images/HtankL2.gif")),
				Tank.tk.getImage(BombTank.class.getResource("Images/HtankR2.gif")),
				Tank.tk.getImage(BombTank.class.getResource("Images/HtankD2.gif")),
				Tank.tk.getImage(BombTank.class.getResource("Images/HtankU2.gif")),
				Tank.tk.getImage(BombTank.class.getResource("Images/HtankL2.gif")),
				Tank.tk.getImage(BombTank.class.getResource("Images/HtankR2.gif")),
				};
    }


    @Override
    public void move(Tank tank) {
        // Increased movement speed
        Tank.speedX = 12;
        Tank.speedY = 12;
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
    public void handlePowerUp(Tank tank) {
        // Already in powered up state, maybe extend duration
    }
} 