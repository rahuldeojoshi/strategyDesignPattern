package src;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import strategyDesign.*;

/**
 * Copyright
 * @author RDJ 
 */
public class PolygonTest {

	/**
	 * Test method for {@link strategyDesign.Polygon#getCalc()}.
	 */
	@Test
	public void testGetCalc() {
		AreaCalculator calc = new TriangleAreaCalc();
		Polygon polygon = new Polygon(null, calc);
		
		
		AreaCalculator calc2 = polygon.getCalc();
		assertThat(calc2, is(sameInstance(calc)));
	}

	/**
	 * Test method for {@link strategyDesign.Polygon#setCalc(strategyDesign.AreaCalculator)}.
	 */
	@Test
	public void testSetCalc() {
		// create a Polygon object with TriangleAreaCalc object
		Polygon polygon = new Polygon(null, new TriangleAreaCalc());
		
		// get a new RectangleAreaCalc 
		AreaCalculator calc = new RectangleAreaCalc();
		// replace previous TriangleAreaCalc with the RectangleAreaCalc created above
		polygon.setCalc(calc);
		
		// check if the call method call sets rectangle by calling getCalc()
		AreaCalculator actualCalc = polygon.getCalc();
		
		// Test
		assertThat(actualCalc, is(sameInstance(calc)));
	}

	/**
	 * Test method for {@link strategyDesign.Polygon#getLocalPoints()}.
	 */
	@Test
	public void testGetLocalPoints() {
		// create an ArrayList to pass to the constructor 
		// of Polygon & check if it actually sets points
		ArrayList<Point> points = new ArrayList<Point>();
		points.add(new Point(1,2)); 
		points.add(new Point(3,2)); 
		points.add(new Point(2,3));
		
		// create a Polygon object passing above arrayList
		Polygon p = new Polygon(points, null);
		
		// get the points from Polygon
		ArrayList<Point> actualPoints = p.getLocalPoints();
		
		// test
		assertThat(actualPoints, is(points));
	}

	/**
	 * Test method for {@link strategyDesign.Polygon#Polygon(java.util.ArrayList, strategyDesign.AreaCalculator)}.
	 */
	@Test
	public void testPolygon() {
		/**
		 * Basically we repeat the Test 1 and 3 above 
		 */
		// create points to pass in constructor of Polygon
		ArrayList<Point> points = new ArrayList<Point>();
		points.add(new Point(1,2)); 
		points.add(new Point(3,2)); 
		points.add(new Point(2,3));
		
		// create an object to pass in constructor of Polygon
		AreaCalculator calc = new TriangleAreaCalc();
		
		// create a Polygon object passing above 2 parameters
		Polygon p = new Polygon(points, calc);
		// get the points from Polygon
		ArrayList<Point> actualPoints = p.getLocalPoints();
		
		// get the AreaCalculator object from Polygon
		AreaCalculator actualCalc = p.getCalc();
		
		// Test
		assertThat(actualPoints, is(points));
		assertThat(actualCalc, is(calc));
		 
	}

	/**
	 * Test method for {@link strategyDesign.Polygon#addPoint(java.awt.Point)}.
	 */
	@Test
	public void testAddPoint() {
		
		// create a Point object to add 
		Point pointP = new Point(3,4);
		
		ArrayList<Point> points = new ArrayList<Point>();
		points.add(new Point(1,2)); 
		points.add(new Point(3,2)); 
		points.add(new Point(2,3));
		
		// create an object of Polygon with an ArrayList with one Point in it
		Polygon p = new Polygon(points, null);
		
		// add the Point
		p.addPoint(pointP);
		
		// get point from Polygon and as we know it is going to be added at index 3
		Point actualPoint = p.getLocalPoints().get(3);
		
		// test
		assertThat(actualPoint, is(sameInstance(pointP)));	
	}

	/**
	 * Test method for {@link strategyDesign.Polygon#getArea()}.
	 */
	@Test
	public void testGetArea() {
		// Create a AreaCalculator object
		AreaCalculator calc = new TriangleAreaCalc();
		
		// Create an ArrayList with 3 points to calculated area of Rectangle
		ArrayList<Point> points = new ArrayList<Point>();
		points.add(new Point(1,2)); 
		points.add(new Point(3,2)); 
		points.add(new Point(2,3));
		
		// Create a Polygon object by passing the above two params
		Polygon p = new Polygon(points, calc);
		
		float actualArea = p.getArea();
		float expectedArea = calc.getArea(points);
		
		// Test
		assertThat(actualArea, is(expectedArea));
		
		// Create a AreaCalculator object
        AreaCalculator calcRect = new RectangleAreaCalc();
				
				
       // adding a point intentionally to violate the condition in RectangleAreaCalc.getArea()
       p.addPoint(new Point(9,4));
				
       // Create a Polygon object by passing the above two params
       p.setCalc(calcRect);
				
       // Area return should be 0
       float actualAreaRect = p.getArea();
       float expectedAreaRect = calcRect.getArea(points);
				
       // Test
       assertThat(actualAreaRect, is(expectedAreaRect));
	}

}
