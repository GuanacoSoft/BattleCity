package Models;


import Controllers.TankClient;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;




public class Tree {
	public static final int width = 30;
	public static final int length = 30;
	int x, y;
	TankClient tc ;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] treeImags = loadTreeImages();

	
	
	public Tree(int x, int y, TankClient tc) { 
		this.x = x;
		this.y = y;
		this.tc = tc;
	}

	public Image[] getTreeImags() {
		return treeImags;
	}

	public int getPosX() {
		return x;
	}

	public int getPosY() {
		return y;
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


	
}
