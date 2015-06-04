package framework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class customButton extends JButton implements MouseListener {
	
	BufferedImage[] images = new BufferedImage[3];
	
	Son sonBoutonClic, sonBoutonEntered;
	
	String[] NomImage = new String[3];
	String libelle;
	
	int h,l;
	int state=0;
	
	public customButton(String libelle){
		super();
		enableInputMethods(true);
		addMouseListener(this);
		this.setBorder(BorderFactory.createEmptyBorder(50, 0, 5, 0));
		this.libelle=libelle;
		
		sonBoutonClic = new Son ("res/sons/bouton-fx-185.wav");
    	sonBoutonEntered = new Son ("res/sons/boutonEntered.wav");
		
			NomImage[0]="LP0.png";
			NomImage[1]="LP1.png";
			NomImage[2]="LP2.png";
			
		try {
			for (int k = 0; k < 3; k++)
				images[k] = ImageIO.read(new File("res/" + NomImage[k]));
		} catch (Exception err) {
			System.out.println(NomImage[0] + " introuvable !");
			System.exit(0);
		}
		
		h = images[0].getHeight(null);			//r�cup�re une fois pour toutes la hauteur et largeur de l'image
		l = images[0].getWidth(null);
	}
	
	
	public Dimension getPreferredSize(){
		return new Dimension(l, h);
	}
	
	public Dimension getMinimumSize() {
		return new Dimension(l, h);
	}
	
	public Dimension getMaximumSize() {
		return new Dimension(l, h);
	}
	
	public void paintComponent(Graphics g) {
		this.paintBorder(g);
		g.drawImage(images[state], 0, 0, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Harrington", 1, 20));
		drawCenteredString(libelle, g);
	}
	
	public void drawCenteredString(String s, Graphics g) {
	    FontMetrics fm = g.getFontMetrics();
	    int x = (l - fm.stringWidth(s)) / 2;
	    int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
	    Graphics2D g2d = (Graphics2D)g.create();					//anti aliasing sur le texte
	    g2d.setRenderingHint(
	            RenderingHints.KEY_TEXT_ANTIALIASING,
	            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2d.drawString(s, x, y);
	  }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		sonBoutonClic.jouer();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		state=2;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		state=1;
		sonBoutonClic.stop();
		sonBoutonEntered.jouer();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		state=0;
	}


}
