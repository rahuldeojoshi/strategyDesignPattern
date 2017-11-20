package strategyDesign;

import java.awt.Point;
import java.util.ArrayList;

/**
 * @author RDJ
 *
 */
public class Polygon {

	/**
	 * Class Variables / Data Fields 
	 */
	private ArrayList<Point> localPoints;
	private AreaCalculator calc;
	
	/**
	 * @return the calc
	 */
	public AreaCalculator getCalc() {
		return calc;
	}
	
	/**
	 * @param calc the calc to set
	 */
	public void setCalc(AreaCalculator calc) {
		this.calc = calc;
	}
	
	/**
	 * @return the localPoints
	 */
	public ArrayList<Point> getLocalPoints() {
		return localPoints;
	}
	
	/**
	 * Constructor Method
	 */
	public Polygon(ArrayList<Point> points , AreaCalculator calc) {
		this.localPoints = points;
		this.calc = calc;
	}

	public void addPoint(Point point){
		this.localPoints.add(point);
	}
	
	public float getArea(){
		return calc.getArea(localPoints);
	}
	
}
