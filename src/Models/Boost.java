package Models;
import java.awt.*;
import java.awt.Rectangle;
import java.util.List;
import Models.CommonWall;
import Models.MetalWall;
import Models.Tree;
import Models.River;

public class Boost {
    private static Image[] boostImage = null;
    private int x, y;
    public static final int width = 30, length = 30;
    private int qttyAppear = 1000;
    private int timePerAppear = 10; // en segundos
    public Boost() {
        this.loadImages();
    }

    public void setX(int x) {
        if (width / 2 + x > 800 || width / 2 + x < 0) {
            throw new IllegalArgumentException("X position out of bounds: " + x);
        }
        this.x = x;
    }   

    public void setY(int y) {
        if (length / 2 + y > 600 || length / 2 + y < 0) {
            throw new IllegalArgumentException("Y position out of bounds: " + y);
        }
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // public void newRandomPosition() {
    //     int x = (int) (Math.random() * (800 - width));
    //     int y = (int) (Math.random() * (600 - length));
    //     setY(y);
    //     setX(x);
    // }

    public void newRandomPosition(List<CommonWall> commonWalls, List<MetalWall> metalWalls, List<Tree> trees, List<River> rivers) {
        boolean validPosition = false;
        int maxTries = 100; // Para evitar bucles infinitos
        int tries = 0;
        while (!validPosition && tries < maxTries) {
            tries++;
            int newX = (int) (Math.random() * (800 - width));
            int newY = (int) (Math.random() * (600 - length));
            Rectangle boostRect = new Rectangle(newX, newY, width, length);

            validPosition = true;

            // Verifica colisión con CommonWall
            for (CommonWall wall : commonWalls) {
                if (boostRect.intersects(new Rectangle(wall.x, wall.y, CommonWall.width, CommonWall.length))) {
                    validPosition = false;
                    break;
                }
            }
            // Verifica colisión con MetalWall
            if (validPosition) {
                for (MetalWall wall : metalWalls) {
                    if (boostRect.intersects(new Rectangle(wall.x, wall.y, MetalWall.width, MetalWall.length))) {
                        validPosition = false;
                        break;
                    }
                }
            }
            // Verifica colisión con Tree
            if (validPosition) {
                for (Tree tree : trees) {
                    if (boostRect.intersects(new Rectangle(tree.x, tree.y, Tree.width, Tree.length))) {
                        validPosition = false;
                        break;
                    }
                }
            }
            // Verifica colisión con River
            if (validPosition) {
                for (River river : rivers) {
                    if (boostRect.intersects(new Rectangle(river.getX(), river.getY(), River.riverWidth, River.riverLength))) {
                        validPosition = false;
                        break;
                    }
                }
            }

            if (validPosition) {
                this.x = newX;
                this.y = newY;
            }
            }
        
    }
    
    
    
    public void loadImages() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        boostImage = new Image[] {
            tk.getImage(getClass().getResource("Images/boost.png"))
        };
        
    }

    public static Image[] getBoostImage() {
        if (boostImage == null) {
            System.out.println("No se pudo cargar la imagen del boost.");
            Toolkit tk = Toolkit.getDefaultToolkit();
            boostImage = new Image[] {
                tk.getImage(Boost.class.getResource("Images/boost.png"))
            };
        }
        System.out.println("La imagene sta cargada.");
        return boostImage;
    }

    public boolean isBoostAvailable() {
        return qttyAppear > 0;
    }

    public int getStepTime() {
        return timePerAppear;
    }

    public void updateQttyAppear(int qtty) {
        if (qtty < 0) {
            qtty = 0;
        }
        this.qttyAppear = qtty;
    }

    public int getQttyAppear() {
        return this.qttyAppear;
    }
}
