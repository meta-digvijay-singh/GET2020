import java.util.Date;
public class Square implements Shape {
    private int width;
    private Point origin;
    private Date currentTime;
    
    public Square (Point origin, int width) {
        this.width = width;
        this.origin = origin;
        currentTime = new Date();
    }
    
    /**
     * Gives area of square.
     * @return area of square.
     */
    @Override
    public double getArea() {
        return width * width;
    }

    /**
     * Gives perimeter of square.
     * @return perimeter of circle.
     */
    @Override
    public double getPerimiter() {
        return 4 * width;
    }

    /**
     * Gives origin of square.
     * @return origin of square.
     */
    @Override
    public Point getOrigin() {
        return origin;
    }

    /**
     * Gives bottom right corner coordinate.
     * @return coordinate of bottom right corner.
     */
    private Point findBottomRightCornerPoint() {
        return new Point(origin.getX() + width, origin.getY());
    }
    
    /**
     * Gives top left corner coordinate.
     * @return coordinate of top left corner.
     */
    private Point findTopLeftCornerPoint() {
        return new Point(origin.getX(), origin.getY() + width);
    }
    
    /**
     * Checks whether point is enclosed by square or not.
     * @return true if point is enclosed, else false.
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
     * Gives time of creation of square.
     * @return time of creation of square.
     */
    public Date getTime() {
        return new Date(currentTime.getTime());
    }
    
    public String toString() {
        return "Square -> Width : " + width + ", Origin : (" + origin.getX() + ", " + origin.getY() + "), Time : " + currentTime;
    }
    
}