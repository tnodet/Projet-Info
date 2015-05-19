package gameframework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.Rectangle;



public class AstreSpherique extends Astre { 	//Astre de forme sph�rique d�fini par son rayon
	
	//Circle limites;
	double rayon;								//Rayon de l'astre

	public AstreSpherique(int ax, int ay, float adx, float ady,	String[] NomImage, Rectangle aframe, String nom, int nbIm, int masse, double rayon) {
		super(ax, ay, adx, ady, NomImage, aframe, nom, "AstreSpherique", nbIm, masse);
		this.rayon=rayon;
		limites = new Area(new Ellipse2D.Double(drawX, drawY, (2*rayon),(2*rayon)));	//Cr�ation de la hitbox : disque de centre (ax,ay)
	}

	@Override
	public void move(long t) {					//Impl�mentation de la m�thode move obligatoire, mais on ne la
												//d�finit pas pour un astre sph�rique pour l'instant

	}
	
	public void draw(long t, Graphics g){
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawImage(images[(int) t % NbImages], drawX, drawY, null);
		
		/*AffineTransform at = new AffineTransform();
		GeneralPath path1 = new GeneralPath();				----------
        path1.append(limites.getPathIterator(at), true);	DEBBUGING : dessin de la hitbox
        g2d.fill(path1);									----------
		*/
	}

}
