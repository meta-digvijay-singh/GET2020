import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Screen {
    private List<Shape> shapeList = new ArrayList<Shape>();
    private int XMIN;
    private int XMAX;
    private int YMIN;
    private int YMAX;
    
    public Screen(final int XMIN, final int XMAX, final int YMIN, final int YMAX) {
        this.XMIN = XMIN;
        this.XMAX = XMAX;
        this.YMIN = YMIN;
        this.YMAX = YMAX;
    }
    
    /**
     * Adds shape to the screen.
     * @param shape
     * @return
     */
    public boolean addShape(Shape shape) {
        if (((shape.getOrigin().getX() >= XMIN) && (shape.getOrigin().getX() <= XMAX))
            && ((shape.getOrigin().getY() >= YMIN) && (shape.getOrigin().getX() <= YMAX))) {
            shapeList.add(shape);
            return true;
        }
        return false;
    }
    
    /**
     * Search whether given shape is present on screen or not.
     * @param shapeName : name of Shape.
     * @return index of shape if found, else -1.
     */
    private int searchShape(String shapeName) {
        int index = -1;
        for (Shape shape : shapeList) {
            String shapeType = shape.getClass().getSimpleName().toLowerCase();
            if (shapeType.equals(shapeName)) {
                index = shapeList.indexOf(shape);
                break;
            }
        }
        return index;
    }
    
    /**
     * Deletes a shape from the screen.
     * @param shapeName : name of shape.
     * @return true if shape get deleted, else false.
     */
    public boolean deleteShape(String shapeName) {
        int index = searchShape(shapeName.toLowerCase());
        if (index == -1) {
            return false;
        }
        shapeList.remove(index);
        return true;
    }
    
    /**
     * Delete all shapes of given name.
     * @param shapeName : name of shape.
     * @return true if all shapes of given name, else false.
     */
    public boolean deleteShapeType (String shapeName) {
        boolean hasRemoved = false;
        shapeName = shapeName.toLowerCase();
        for (int shapeIndex = 0; shapeIndex < shapeList.size(); shapeIndex++) {
            if (shapeList.get(shapeIndex).getClass().getSimpleName().toLowerCase().equals(shapeName)) {
                shapeList.remove(shapeIndex);
                shapeIndex--;
                hasRemoved = true;
            }
        }
        return hasRemoved;
    }
    
    /**
     * Gives list of shapes enclosing a given point.
     * @param point : point to be checked.
     * @return list of shapes enclosing a point, else empty list.
     */
    public List<Shape> getEnclosingShapes(Point point) {
        List<Shape> enclosingShapes = new ArrayList<Shape>();
        for (Shape shape : shapeList) {
            if (shape.isPointEnclosed(point)) {
                enclosingShapes.add(shape);
            }
        }
        return enclosingShapes;
    }
    
    /**
     * Gives list of shapes sorted by area.
     * @return list of shapes based on area, else empty list.
     */
    public List<Shape> getShapesSortedByArea() {
        List<Shape> list = new ArrayList<Shape>(shapeList);
        Collections.sort(list, new CompareShapesByArea());
        return list;
    }
    
    /**
     * Gives list of shapes sorted by perimeter.
     * @return list of shapes sorted by perimeter, else empty list.
     */
    public List<Shape> getShapeSortedByPerimeter() {
        List<Shape> list = new ArrayList<Shape>(shapeList);
        Collections.sort(list, new CompareShapesByPerimeter());
        return list;
    }
    
    /**
     * Gives list of shapes sorted by origin.
     * @return list of shapes sorted by origin, else empty list.
     */
    public List<Shape> getShapeSortedByOrigin() {
        List<Shape> list = new ArrayList<Shape>(shapeList);
        Collections.sort(list, new CompareShapesByOrigin());
        return list;
    }
    
    /**
     * Gives list of shapes sorted by the time added to the screen.
     * @return list of shapes sorted by time, else empty list.
     */
    public List<Shape> getShapeSortedByTime() {
        List<Shape> list = new ArrayList<Shape>(shapeList);
        Collections.sort(list, new CompareShapesByTime());
        return list;
    }
    
    /**
     * Gives all list of shapes.
     * @return list of shapes if exist, else empty list.
     */
    public List<Shape> getAllShapes() {
        return new ArrayList<Shape>(shapeList);
    }
    
    private class CompareShapesByArea implements Comparator<Shape> {
        public int compare(Shape shape1, Shape shape2) {
            return Double.compare(shape1.getArea(), shape2.getArea());
        }
    }
    
    private class CompareShapesByPerimeter implements Comparator<Shape> {
        public int compare(Shape shape1, Shape shape2) {
            return Double.compare(shape1.getPerimiter(), shape2.getPerimiter());
        }
    }
    
    private class CompareShapesByOrigin implements Comparator<Shape> {
        
        private double calculateDistance(Point firstPoint, Point secondPoint) {
            double yTerm = Math.pow(secondPoint.getY() - firstPoint.getY(), 2);
            double xTerm = Math.pow(secondPoint.getX() - firstPoint.getX(), 2);
            return Math.pow(yTerm + xTerm, 1/2);
        }
        
        public int compare(Shape shape1, Shape shape2) {
            double originDistanceShape1 = calculateDistance(shape1.getOrigin(), new Point(XMIN, YMIN));
            double originDistanceShape2 = calculateDistance(shape1.getOrigin(), new Point(XMIN, YMIN));
            return Double.compare(originDistanceShape1, originDistanceShape2);
        }
    }
    
    private class CompareShapesByTime implements Comparator<Shape> {
        public int compare(Shape shape1, Shape shape2) {
            return shape1.getTime().compareTo(shape2.getTime());
        }
    }
}