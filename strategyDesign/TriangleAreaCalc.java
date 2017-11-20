/**
 * 
 */
package strategyDesign;

import java.awt.Point;
import java.util.ArrayList;

/**
 * @author RDJ
 *
 */
public class TriangleAreaCalc implements AreaCalculator {

	/**
	 * Points a,b,c to store values from ArrayList points
	 * area, s, aLength, bLength, cLength for calculating 
	 * AreaOfTriangle
	 */
	private Point a,b,c;
	private double area, s, aLength, bLength, cLength;

	@Override
	public float getArea(ArrayList<Point> points) {
		a = points.get(0);
		b = points.get(1);
		c = points.get(2);
		aLength = Math.sqrt(Math.pow((b.getX()-a.getX()),2) + Math.pow((b.getY()-a.getY()), 2));
		bLength = Math.sqrt(Math.pow((c.getX()-b.getX()),2) + Math.pow((c.getY()-b.getY()), 2));
		cLength = Math.sqrt(Math.pow((a.getX()-c.getX()),2) + Math.pow((a.getY()-c.getY()), 2));
		s = (aLength+bLength+cLength)/2;
		area =  Math.abs(Math.sqrt(s*(s-aLength)*(s-bLength)*(s-cLength)));
		return (float)area;
	}

}
