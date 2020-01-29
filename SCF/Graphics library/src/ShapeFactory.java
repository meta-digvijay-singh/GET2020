import java.util.List;
public class ShapeFactory {
    /**
     * Allows creation of shape based on given type.
     * @param type : type of shape.
     * @param origin : origin of shape.
     * @param values : shape parameters related to the shape.
     * @return
     */
    public static Shape createShape(Shape.ShapeType type, Point origin, List<Integer> valueList) {
        Shape shape = null;
        switch(type) {
            case CIRCLE:
                if (valueList.size() == 1) {
                    shape = new Circle(origin, valueList.get(0));
                }
                break;
                
            case RECTANGLE:
                if (valueList.size() == 2) {
                    shape = new Rectangle(origin, valueList.get(0), valueList.get(1));
                }
                break;
                
            case SQUARE:
                if (valueList.size() == 1) {
                    shape = new Square(origin, valueList.get(0));
                }
                break;
                
            case TRIANGLE:
                if (valueList.size() == 3) {
                    shape = new Triangle(origin, valueList.get(0), valueList.get(1), valueList.get(2));
                }
                break;
        }
        return shape;
    }
}