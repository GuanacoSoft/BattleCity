package Models;
import java.awt.Graphics;

public interface TankState {
    void move(Tank tank);
    void fire(Tank tank);
    void handleDamage(Tank tank, int damage);
    void draw(Graphics g, Tank tank);
    void handlePowerUp(Tank tank);
} 