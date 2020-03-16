import java.util.Date;
public class Circle implements Shape{
    private int radius;
    private Point origin;
    private final double PI = Math.PI;
    private Date currentTime;
    
    /**
     * Instantiate a circle.
     * @param origin : origin of circle.
     * @param radius : radius of circle.
     */
    public Circle(Point origin, int radius) {
        this.origin = origin;
        this.radius = radius;
        currentTime = new Date();
    }
    
    /**
     * Gives area of circle.
     * @return area of circle.
     */
    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    /**
     * Gives perimeter of circle.
     * @return perimeter of circle.
     */
    @Override
    public double getPerimiter() {
        return 2 * PI * radius;
    }

    /**
     * Gives origin of circle.
     * @return origin of circle.
     */
    @Override
    public Point getOrigin() {
        return origin;
    }

    /**
     * Calculate distance between given points.
     * @param firstPoint : first point.
     * @param secondPoint : second point.
     * @return distance between given points.
     */
    private double calculateDistance(Point firstPoint, Point secondPoint) {
        double yTerm = Math.pow(secondPoint.getY() - firstPoint.getY(), 2);
        double xTerm = Math.pow(secondPoint.getX() - firstPoint.getX(), 2);
        return Math.pow(yTerm + xTerm, 1/2);
    }
    
    /**
     * calculate distance of center of circle from origin of screen.
     * @return distance between center and origin of screen.
     */
    private double calculateCenterDistance() {
        final double SQUARE_ROOT = 1/2;
        final int SQUARE = 2;
        double originXSquare = Math.pow(origin.getX(), SQUARE);
        double originYSquare = Math.pow(origin.getY(), SQUARE);
        double originDistanceFromScreenOrigin = Math.pow(originXSquare + originYSquare, SQUARE_ROOT);
        return originDistanceFromScreenOrigin + radius;
    }
    
    /**
     * Finds coordinate of center point.
     * @return coordinate of center of circle.
     */
    private Point findCenterPoint() {
        double hypotenuse = calculateCenterDistance();
        double theta = Math.atan(origin.getY() / origin.getX());
        double base = Math.cos(theta) * hypotenuse;
        double perpendicular = Math.sin(theta) * hypotenuse;
        return new Point(base, perpendicular);
        
    }
    
    /**
     * Checks whether point is enclosed by circle.
     * @return true if given point is enclosed by circle, else false.
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        Point centerCoordinate  = findCenterPoint();
        double distanceBetweenOriginAndPoint = calculateDistance(point, centerCoordinate);
        if (distanceBetweenOriginAndPoint <= radius) {
            return true;
        }
        return false;
    }
    
    /**
     * Gives time when circle is created.
     * @return time of circle creation.
     */
    public Date getTime() {
        return new Date(currentTime.getTime());
    }
    
    public String toString() {
        return "Circle -> Radius : " + radius + ", Origin : (" + origin.getX() + ", " + origin.getY() + "), Time : " + currentTime;
    }

}
