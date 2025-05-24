import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.io.File;
/**
 * \brief
 * @author Jignesh Chudasama
 */
public class Tree {
	public static final int width = 30;
	public static final int length = 30;
	int x, y;
	TankClient tc ;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] treeImags = loadTreeImages();
	private int currentImageIndex = 0;
	
	
	public Tree(int x, int y, TankClient tc) { 
		this.x = x;
		this.y = y;
		this.tc = tc;


		new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (treeImags.length > 0) {
					currentImageIndex = (currentImageIndex + 1) % treeImags.length;
				}
			}
		}).start();
	}
	
	


	private static String[] getTreeImageFiles() {
		try {
			URL url = Tree.class.getClassLoader().getResource("images");
			if (url == null) return new String[0];
			File dir = new File(url.toURI());
			return dir.list((d, name) -> name.toLowerCase().contains("tree"));
		} catch (Exception e) {
			e.printStackTrace();
			return new String[0];
		}
	}

	
	private static Image[] loadTreeImages() {
		String[] files = getTreeImageFiles();
		Image[] images = new Image[files.length];
		for (int i = 0; i < files.length; i++) {
			images[i] = tk.getImage(Tree.class.getClassLoader().getResource("images/" + files[i]));
		}
		return images;
	}

	public void draw(Graphics g) {        
		if (treeImags.length > 0) {
			g.drawImage(treeImags[currentImageIndex], x, y, null);
		}
	}
	
}
