import java.util.Date;
public class Rectangle implements Shape {
    private int length;
    private int breadth;
    private Point origin;
    private Date currentTime;
    
    public Rectangle(Point origin, int length, int breadth) {
        this.origin = origin;
        this.length = length;
        this.breadth = breadth;
        currentTime = new Date();
    }
    
    /**
     * Gives area of rectangle.
     * @return area of rectangle.
     */
    @Override
    public double getArea() {
        return length * breadth;
    }

    /**
     * Gives perimeter of rectangle.
     * @return preimeter of rectangle.
     */
    @Override
    public double getPerimiter() {
        return 2 * (length + breadth);
    }

    /**
     * Gives origin of rectangle.
     * @return coordinate of origin.
     */
    @Override
    public Point getOrigin() {
        return origin;
    }

    /**
     * Finds bottom right corner of rectangle.
     * @return coordinate of bottom right corner.
     */
    private Point findBottomRightCornerPoint() {
        return new Point(origin.getX() + length, origin.getY());
    }
    
    /**
     * Finds top left corner of rectangle.
     * @return coordinate of top left corner of rectangle.
     */
    private Point findTopLeftCornerPoint() {
        return new Point(origin.getX(), origin.getY() + breadth);
    }
    
    /**
     * Checks whether point is enclosed by rectangle or not.
     * @return true if point is enclosed by rectangle, else false.
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        Point bottomRightCorner = findBottomRightCornerPoint();
        Point topLeftCorner = findTopLeftCornerPoint();
        if (((point.getX() >= origin.getX()) && (point.getX() <= bottomRightCorner.getX())) &&
            ((point.getY() >= origin.getY()) && (point.getY() <= topLeftCorner.getY()))) {
            return true;
        }
        return false;
    }
    
    /**
     * Gives time of creation of rectangle.
     */
    public Date getTime() {
        return new Date(currentTime.getTime());
    }
    
    public String toString() {
        return "Rectangle -> Length : " + length + ", Breadth : " + breadth + ", Origin : (" + origin.getX() + ", " + origin.getY() + "), Time : " + currentTime;
    }
    
}