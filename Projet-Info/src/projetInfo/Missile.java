package projetInfo;

import javafx.scene.shape.Rectangle;

import javafx.scene.shape.Polygon;

public class Missile extends Astre {
	Polygon limites;

	public Missile(Rectangle aframe, String[] tab) {
		super(500, 500, (float)0, (float)0, tab, aframe, "Missile.png", 1, 100);
		
		limites = new Polygon(5.0 ,50, 10.0, 0.0, 0.0,0.0);
	}

	@Override
	public void move(long t) {
		int cAstres =0;
		double xAstre=0.0;
		double yAstre=0.0;
		int masse =0;
		while (liste.get(cAstres)!=null){
			xAstre= liste.get(cAstres).centreG.x;
			yAstre= liste.get(cAstres).centreG.y;
			masse = liste.get(cAstres).masse;
			// determiner angle a partir de deltax et deltay. Calculer force en norme. Projeter en dx dy.
		}
		
	}

}
