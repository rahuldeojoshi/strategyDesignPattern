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
public class RectangleAreaCalc implements AreaCalculator {

	/**
	 * Points for ArrayList points
	 * and sides of the rectangle in double
	 */
	private Point a,b,c,d;
	private double ab, bc, cd, da, area;
	@Override
	public float getArea(ArrayList<Point> points) {
		a = points.get(0);
		b = points.get(1);
		c = points.get(2);
		d = points.get(3);
		ab = Math.abs(Math.sqrt(Math.pow((b.getX()-a.getX()),2) + Math.pow((b.getY()-a.getY()), 2)));
		bc = Math.abs(Math.sqrt(Math.pow((c.getX()-b.getX()),2) + Math.pow((c.getY()-b.getY()), 2)));
		cd = Math.abs(Math.sqrt(Math.pow((d.getX()-c.getX()),2) + Math.pow((d.getY()-c.getY()), 2)));
		da = Math.abs(Math.sqrt(Math.pow((a.getX()-d.getX()),2) + Math.pow((a.getY()-d.getY()), 2)));
		
		if(ab==cd && bc==da){
			area = ab*bc;
		    return (float)area;
		}else{
			return (float)0.0;
		}
	}

}
