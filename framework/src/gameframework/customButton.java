package gameframework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;

public class customButton extends JButton implements MouseListener, ActionListener {
	
	BufferedImage[] images = new BufferedImage[3];
	
	String[] NomImage = new String[3];
	String libell�;
	
	int h,l;
	int state=0;
	
	public customButton(String libell�){
		super(libell�);
		enableInputMethods(true);
		addMouseListener(this);
		
		this.libell�=libell�;
		
		switch(libell�){
		case "Lancer une partie":
			NomImage[0]="LP0.png";
			NomImage[1]="LP1.png";
			NomImage[2]="LP2.png";
			break;
		}
		
		try {
			for (int k = 0; k < 3; k++)
				images[k] = ImageIO.read(new File("C:\\Users\\FALLOUH\\git\\Projet-Info\\test_menu\\res\\" + NomImage[k]));
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
		//super.paintComponent(g);
		g.drawImage(images[state], 0, 0, null);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Harrington", 1, 20));
		g.drawString(libell�, l/2-90, h/2+5);
	}
	protected void paintBorder(Graphics g){
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		state=0;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}