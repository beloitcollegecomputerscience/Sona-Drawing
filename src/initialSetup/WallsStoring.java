package src.initialSetup;

public class WallsStoring {
    private double x;
    private double y;
    private double z;//horizontal:1 vertical:2

    private double length;
    public WallsStoring(double x, double y, double z, double length) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.length = length;

    public Wall createWalls(){
        Wall rect = new wall(x, y, z, length);
        return rect;
        }

    public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
    ArrayList<Wall> walls = new ArrayList<>();

    // Add horizontal walls
    walls.add(new Wall(50, 50, 1,100));
    walls.add(new Wall(200, 50, 1, 150));
    walls.add(new Wall(400, 150, 1, 100));

    // Add vertical walls
    walls.add(new Wall(50, 50, 2, 100));
    walls.add(new Wall(50, 200, 2, 150));
    walls.add(new Wall(250, 100, 2, 50));
    }
}