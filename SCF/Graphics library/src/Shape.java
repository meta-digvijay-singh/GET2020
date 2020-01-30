import java.util.Date;
public interface Shape {
    double getArea();
    double getPerimiter();
    Point getOrigin();
    boolean isPointEnclosed(Point point);
    Date getTime();
    
    enum ShapeType {
        CIRCLE, SQUARE, RECTANGLE, TRIANGLE
    }
}
