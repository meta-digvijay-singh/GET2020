import java.util.Date;
public class Triangle implements Shape {
    private int baseSide, leftSide, rightSide;
    private Point origin;
    private Date currentTime;
    
    public Triangle(Point origin, int baseSide, int leftSide, int rightSide) {
        this.origin = origin;
        this.baseSide = baseSide;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        currentTime = new Date();
    }
    
    /**
     * Gives area of triangle.
     * @return area of triangle.
     */
    @Override
    public double getArea() {
        double semiPerimeter = (baseSide + leftSide + rightSide) / 2;
        double rootTerm = (semiPerimeter * (semiPerimeter - baseSide) *
                          (semiPerimeter - leftSide) * (semiPerimeter - rightSide));
        double area = Math.pow(rootTerm, 1/2);
        return area;
    }

    /**
     * Gives perimeter of triangle.
     * @return perimeter of triangle.
     */
    @Override
    public double getPerimiter() {
        return baseSide + leftSide + rightSide;
    }

    /**
     * Gives origin of triangle.
     * @return coordinate of origin of triangle.
     */
    @Override
    public Point getOrigin() {
        return origin;
    }
    
    /**
     * Gives are of triangle given three coordinates.
     * @param first : first coordinate.
     * @param second : second coordinate.
     * @param third : third coordinate.
     * @return gives area of triangle.
     */
    private double getArea(Point first, Point second, Point third) {
        return ((first.getX() * (second.getY() - third.getY()) 
                + second.getX() * (third.getY() - first.getY()) 
                + third.getX() * (first.getY() - second.getY())));
    }
    
    /**
     * Checks whether given point is enclosed by triangle.
     * @return true if point is enclosed by triangle, else false.
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        double height = (getArea() * 2) / baseSide;
        double angle = Math.asin(height / leftSide);
        double halfBase = height * Math.tan(angle);
        Point top =  new Point(origin.getX() * halfBase, origin.getY() + height);
        Point bottomRightCorner = new Point(origin.getX() + baseSide, origin.getX());
        double totalArea = getArea(origin, top, bottomRightCorner);
        double firstTriangleArea = getArea(origin, top, point);
        double secondTriangleArea = getArea(origin, point, bottomRightCorner);
        double thirdTriangleArea = getArea(top, point, bottomRightCorner);
        if (Math.abs((totalArea - (firstTriangleArea + secondTriangleArea + thirdTriangleArea))) <= 0.1) {
            return true;
        }
        return false;
    }
    
    /**
     * Gives creation time of triangle.
     * @return creation time of triangle.
     */
    public Date getTime() {
        return new Date(currentTime.getTime());
    }
    
    public String toString() {
        return "Triangle -> Base : " + baseSide + ", LeftSide : " + leftSide + ", RightSide : "
               + rightSide + ", Origin : (" + origin.getX() + ", " + origin.getY() + "), Time : " + currentTime;
    }
}