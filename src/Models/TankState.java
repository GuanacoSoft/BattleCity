package Models;
import java.awt.Graphics;

public interface TankState {
    void loadImages(Tank tank);
    void move(Tank tank);
    void fire(Tank tank);
    void handleDamage(Tank tank, int damage);
    void handlePowerUp(Tank tank);
} 