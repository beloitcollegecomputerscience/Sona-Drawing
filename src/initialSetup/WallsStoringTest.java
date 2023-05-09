package src.initialSetup;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WallsStoringTest {

    @Test
    public void testCreateWalls() {
        WallsStoring wall1 = new WallsStoring(50, 50, 1, 100);
        Wall expected1 = new Wall(50, 50, 1, 100);
        Wall actual1 = wall1.createWalls();
        assertEquals(expected1, actual1);

        WallsStoring wall2 = new WallsStoring(200, 50, 1, 150);
        Wall expected2 = new Wall(200, 50, 1, 150);
        Wall actual2 = wall2.createWalls();
        assertEquals(expected2, actual2);

        WallsStoring wall3 = new WallsStoring(400, 150, 1, 100);
        Wall expected3 = new Wall(400, 150, 1, 100);
        Wall actual3 = wall3.createWalls();
        assertEquals(expected3, actual3);
    }

    @Test
    public void testAddWalls() {
        ArrayList<Wall> walls = new ArrayList<>();
        walls.add(new Wall(50, 50, 1, 100));
        walls.add(new Wall(200, 50, 1, 150));
        walls.add(new Wall(400, 150, 1, 100));
        walls.add(new Wall(50, 50, 2, 100));
        walls.add(new Wall(50, 200, 2, 150));
        walls.add(new Wall(250, 100, 2, 50));

        assertEquals(6, walls.size());

        Wall expected1 = new Wall(50, 50, 1, 100);
        Wall actual1 = walls.get(0);
        assertEquals(expected1, actual1);

        Wall expected2 = new Wall(200, 50, 1, 150);
        Wall actual2 = walls.get(1);
        assertEquals(expected2, actual2);

        Wall expected3 = new Wall(400, 150, 1, 100);
        Wall actual3 = walls.get(2);
        assertEquals(expected3, actual3);

        Wall expected4 = new Wall(50, 50, 2, 100);
        Wall actual4 = walls.get(3);
        assertEquals(expected4, actual4);

        Wall expected5 = new Wall(50, 200, 2, 150);
        Wall actual5 = walls.get(4);
        assertEquals(expected5, actual5);

        Wall expected6 = new Wall(250, 100, 2, 50);
        Wall actual6 = walls.get(5);
        assertEquals(expected6, actual6);
    }
}