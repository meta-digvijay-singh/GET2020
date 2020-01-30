import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * traverse given shapes.
     * @param shapes : shapes to be traversed.
     */
    private static void showShapes(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
    
    /**
     * Gives user instructions.
     */
    private static void userInstructions() {
        System.out.println("Instructions : Press below keys for operation");
        System.out.println("1. See Instructions.");
        System.out.println("2. Add Shape to the screen.");
        System.out.println("3. Remove Shape from the screen.");
        System.out.println("4. Remove all shapes of specific types from the screen.");
        System.out.println("5. Sort Shapes based on [Area, Perimeter, Origin, Time]");
        System.out.println("6. Check which shapes encloses a point.");
        System.out.println("7. Get all the shapes.");
        System.out.println("8. Exit.");
    }
    
    /**
     * sort shapes based on the given type.
     * @param basis : basis on which shapes will be sorted.
     * @param screen : screen object.
     * @return list of shapes sorted by given type.
     */
    private static List<Shape> sortShapes(String basis, Screen screen) {
        List<Shape> shapes = new ArrayList<Shape>();
        switch (basis) {
            case "area":
                shapes = screen.getShapesSortedByArea();
                break;
                
            case "perimeter":
                shapes = screen.getShapeSortedByPerimeter();
                break;
                
            case "origin":
                shapes = screen.getShapeSortedByOrigin();
                break;
                
            case "time":
                shapes = screen.getShapeSortedByTime();
                break;
            
            default:
                System.out.println("Can not sort on basis of : " + basis);                
        }
        return shapes;
    }
    
    /**
     * Allows user to provide only positive double value.
     * @return value entered by user.
     */
    private static double getPositiveDouble() {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(sc.nextLine());
                if (value < 0) {
                    throw new Exception("Valur should be positive");
                }
                return value;
            } catch (Exception ex) {
                System.out.println(ex.getMessage() + ", Enter value again : ");
            }
        }
    }
    
    /**
     * Allows user to enter only positive integer.
     * @return value entered by user.
     */
    private static int getPositiveInteger() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(sc.nextLine());
                if (value <= 0) {
                    throw new Exception("Valur should be positive");
                }
                return value;
            } catch (Exception ex) {
                System.out.println(ex.getMessage() + ", Enter value again : ");
            }
        }
    }
    
    /**
     * Takes origin from the user.
     * @return coordinates entered by user.
     */
    private static Point getOriginCoordinate() {
        double x, y;
        System.out.println("Enter x-coordinate : ");
        x = getPositiveDouble();
        System.out.println("Enter y-coordinate : ");
        y = getPositiveDouble();
        return new Point(x, y);
    }
    
    /**
     * Gives shape created based on the given type.
     * @return shape created by user.
     */
    private static Shape getShape() {
        Point origin = null;
        List<Integer> values = new ArrayList<Integer>();
        
        while (true) {
            try {
                Shape.ShapeType shapeName;
                System.out.println("Allowed Shapes : [CIRCLE, RECTANGLE, TRIANGLE, SQUARE]");
                System.out.println("Enter shape name : ");
                shapeName = Shape.ShapeType.valueOf(sc.nextLine().toUpperCase());
                
                switch (shapeName) {
                    case CIRCLE:
                        origin = getOriginCoordinate();
                        System.out.println("Enter radius : ");
                        values.add(getPositiveInteger());
                        break;
                    
                    case RECTANGLE:
                        origin = getOriginCoordinate();
                        System.out.println("Enter length : ");
                        values.add(getPositiveInteger());
                        System.out.println("Enter breadth : ");
                        values.add(getPositiveInteger());
                        break;
                    
                    case SQUARE:
                        origin = getOriginCoordinate();
                        System.out.println("Enter width : ");
                        values.add(getPositiveInteger());
                        break;
                    
                    case TRIANGLE:
                        origin = getOriginCoordinate();
                        System.out.println("Enter base : ");
                        values.add(getPositiveInteger());
                        System.out.println("Enter left side : ");
                        values.add(getPositiveInteger());
                        System.out.println("Enter right side : ");
                        values.add(getPositiveInteger());
                        break;
                }
                
                return ShapeFactory.createShape(shapeName, origin, values);
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid shape type.");
            }
        }
        
    }
    
    /**
     * Starts the runner.
     * @param screen : screen object.
     */
    private static void start(Screen screen) {
        int choice = 1;
        boolean isExit = false;
        Shape shape = null;
        Point point = null;
        while (true) {
            switch (choice) {
                case 1:
                    userInstructions();
                    break;
                
                case 2:
                    shape = getShape();
                    if (screen.addShape(shape)) {
                        System.out.println("Shape added.");
                    } else {
                        System.out.println("Shape could not added.");
                    }
                    break;
                  
                case 3:
                    System.out.println("Enter shape name : ");
                    if (screen.deleteShape(sc.nextLine())) {
                        System.out.println("Shape removed.");
                    } else {
                        System.out.println("Shape is not present.");
                    }
                    break;
                    
                case 4:
                    System.out.println("Enter shape type : ");
                    if (screen.deleteShapeType(sc.nextLine())) {
                        System.out.println("All shapes removed.");
                    } else {
                        System.out.println("Shape is not present.");
                    }
                    break;
                    
                case 5:
                    System.out.println("Enter basis of sorting [Area, Perimeter, Origin, Time] : ");
                    showShapes(sortShapes(sc.nextLine(), screen));
                    break;
                    
                case 6:
                    point = getOriginCoordinate();
                    showShapes(screen.getEnclosingShapes(point));
                    break;
                    
                case 7:
                    showShapes(screen.getAllShapes());
                    break;
                
                case 8:
                    isExit = true;
                    break;
            }
            
            if (isExit) {
                break;
            }
            System.out.println("Enter choice : ");
            choice = getPositiveInteger();
        }
    }
    
    public static void main(String[] args) {
        start(new Screen(0, 1000, 0, 1000));
    }
}