/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package turtle;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import TurtleGraphics.Turtle;
import TurtleGraphics.Sheet;


public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(DrawableTurtle turtle, int sideLength) {
        //Dessin de Rectangle/Carre
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    }

    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
    	//Calculer l'angle interne du polygone regulier a partir du nombre de cote
    	
    	if(sides<2)	
    		return 0;
    	else
    		return (double)((sides-2)*180)/sides;
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
    	
    	//Calcul du nombre de cote du polygone  a partir de l'angle
    	int side=0;
    	if(angle>0 && angle<180)
    		side=(int) (360/(180-angle)+0.5);
        return side;
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(DrawableTurtle turtle, int sides, int sideLength) {
       
    	//Dessin de polygone regulier
    	for(int i=0;i<sides;i++){
    	   turtle.forward(sideLength);
    	   //Affichage du l'angle interne du polygone
    	   System.out.println("Angle interne du polygone=>"+calculateRegularPolygonAngle(sides));
    	   turtle.turn(calculateRegularPolygonAngle(sides));
       }
       
    }

    /**
     * Given the current direction, current location, and a target location, calculate the heading
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentHeading. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentHeading current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to heading (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateHeadingToPoint(double currentHeading, int currentX, int currentY,
                                                 int targetX, int targetY) {
    	
    	/*
    	 Calcul de l'angle de la direction d'orientation de la tortue
    	 */
    	double angle=Math.toDegrees(Math.atan2(targetX - currentX, targetY - currentY))-currentHeading;
    	if(angle < 0)
    		angle += 360;		
    	return angle; 
    }

    /**
     * Given a sequence of points, calculate the heading adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateHeadingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of heading adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateHeadings(List<Integer> xCoords, List<Integer> yCoords) {
       
    	//Taille de xCoords
    	int n = xCoords.size();
    	
    	//Liste des ajustement
    	List<Double> Malist=new ArrayList<>();
    	
    	//Recuperer angle par la fonction calculateHeadingToPoint
    	double angle = calculateHeadingToPoint(0, xCoords.get(0), yCoords.get(0), xCoords.get(1), yCoords.get(1));
    	Malist.add(angle);
    	double adjustment = 0;
    	
    	//Parcours de xCoords et Remplissage de Malist
    	for(int i = 1; i < n-1; i++)
    	{
    		adjustment = calculateHeadingToPoint(angle, xCoords.get(i), yCoords.get(i), xCoords.get(i+1), yCoords.get(i+1));
    		angle = angle +adjustment;
    		angle = angle > 360 ? angle-360 : angle;
    		Malist.add(adjustment);
    	}
    	
    	//Retour de Malist
    	return Malist;
    }

    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param d the turtle context
     */
    public static void drawPersonalArt(DrawableTurtle d) {
    
    	//Dessin de decoration d'etoile multiple
    	
    	//Definition de couleur
    	PenColor p=null;
    	
    	//Boucle de repetition de figure de decoration
    	for(int c=0;c<2;c++){
    		
    		//Boucle de dessin d'un figure
	    	for(int i=0;i<12;i++){
	    		d.color(p.BLUE);
	    		d.forward(150);
	    		d.turn(150);
	    		
	    		for(int j=0;j<12;j++){
	    			//d.color(p.GREEN);
	    			d.forward(50);
	    			d.turn(150);
	    		}
	    	}
	    	//Decallage pour dessiner une autre figure
	    	d.color(p.GRAY);
	    	d.forward(-100);
	    	d.turn(135);
    	}
    }
    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();
        drawSquare(turtle, 40);

        // draw the window
        turtle.draw();
        
       //Dessin du ploygone
        DrawableTurtle poly = new DrawableTurtle();
        drawRegularPolygon(poly,10,90);
       // poly.draw();
        
        //Dessin de art personnnel
        
        DrawableTurtle d= new DrawableTurtle();
        drawPersonalArt(d);
        d.draw();
        
    }

}
