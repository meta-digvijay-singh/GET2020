package Assignment3;

public class Area {
    
    /**
     * Calculates area of right angle triangle.
     * @param width : width of triangle.
     * @param height : height of triangle.
     * @return area of right angle triangle i.e. (width * height) / 2;
     * @throw if width or height is less than zero.
     */
    public double areaOfTriangle(double width, double height) throws ArithmeticException {
        if ((width < 0) || (height < 0)) {
            throw new ArithmeticException("Base or height can't be negative.");
        }
        
        final double area = (width * height) / 2;
        return area;
    }
    
    /**
     * Calculates area of rectangle.
     * @param width : width of rectangle.
     * @param height : height of rectangle.
     * @return area of rectangle i.e. width * height.
     * @throw if width or height is less than zero.
     */
    public double areaOfRectangle(double width, double height) throws ArithmeticException {
        if ((width < 0) || (height < 0)) {
            throw new ArithmeticException("Length or breadth can't be negative");
        }
        
        final double area = width * height;
        return area;
    }
    
    /**
     * Calculates area of square.
     * @param width : width of square.
     * @return area of square i.e. width * width.
     * @throw if width is less than zero.
     */
    public double areaOfSquare(double width) throws ArithmeticException {
        final double area = areaOfRectangle(width, width);
        return area;
    }
    
    /**
     * Calculates area of circle.
     * @param radius : radius of circle.
     * @return area of circle i.e. PI * radius * radius.
     * @throw if radius is less than zero.
     */
    public double areaOfCircle(double radius) throws ArithmeticException {
        if (radius < 0) {
            throw new ArithmeticException("Radius can't be negative.");
        }
        
        final double area = Math.PI * radius * radius;
        return area;
    }
}