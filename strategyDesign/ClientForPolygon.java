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
public class ClientForPolygon {

	/**
	 * variables
	 */
	private ArrayList<Point> points;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClientForPolygon test = new ClientForPolygon();
		test.points = new ArrayList<Point>();
		test.points.add(new Point(1,2)); 
		test.points.add(new Point(3,2)); 
		test.points.add(new Point(2,3));
		
		Polygon p = new Polygon(test.points, new TriangleAreaCalc());
		
		System.out.println("Printing the Area of Triangle from TriangleAreaCalc class: " + p.getArea());
		System.out.println();
		
		/**
		 * Adding another point for dynamically changing 
		 * it to Rectangle and then calculated area of rectangle
		 * The point added here abides the rule for rectangle (opposite
		 * side are equal) 
		 */
		System.out.println("Adding another point using addPoint in Polygon....");
		p.addPoint(new Point(2,1));
		System.out.println("Added point: (2,1)");

		// setting new Rectangle() for "Polygon p"
		System.out.println("Transforming Triangle to Rectangle.....");
		System.out.println();
		p.setCalc(new RectangleAreaCalc());
		
		System.out.print("Printing area of Rectangle from RectangleAreaCalc class: " + p.getArea());
	}

}
