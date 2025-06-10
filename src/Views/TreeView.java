package Views;
import Models.Tree;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TreeView {

    public Tree tree;
	private int currentImageIndex = 0;

    
    public TreeView(Tree tree) {
        this.tree = tree;

        new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tree.getTreeImags().length > 0) {
					currentImageIndex = (currentImageIndex + 1) % tree.getTreeImags().length;
				}
			}
		}).start();

    }


    public void draw(Graphics g) {        
		if (tree.getTreeImags().length > 0) {
			g.drawImage(tree.getTreeImags()[currentImageIndex], tree.getPosX(), tree.getPosY(), null);
		}
	}



    

}
