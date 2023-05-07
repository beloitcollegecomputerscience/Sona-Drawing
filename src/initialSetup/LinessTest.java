package liness;
import java.util.ArrayList;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinessTest {
    
    @Test
    public void testCollection() {
        Liness Liness = new Liness();

        // Call the collection() method
        ArrayList<Shape> shapes = Liness.collection();

        // Assert that the collection contains the correct number of shapes
        assertEquals(5, shapes.size());

        // Assert that the collection contains the correct shapes
        assertTrue(shapes.get(0) instanceof Line);
        assertTrue(shapes.get(1) instanceof Line);
        assertTrue(shapes.get(2) instanceof Line);
        assertTrue(shapes.get(3) instanceof Line);
        assertTrue(shapes.get(4) instanceof Arc);

        Line line1 = (Line) shapes.get(0);
        assertEquals(100.0, line1.getStartX(), 0.1);
        assertEquals(50.0, line1.getStartY(), 0.1);
        assertEquals(90.0, line1.getEndX(), 0.1);
        assertEquals(200.0, line1.getEndY(), 0.1);

        Line line2 = (Line) shapes.get(1);
        assertEquals(90.0, line2.getStartX(), 0.1);
        assertEquals(200.0, line2.getStartY(), 0.1);
        assertEquals(180.0, line2.getEndX(), 0.1);
        assertEquals(40.0, line2.getEndY(), 0.1);

        Line line3 = (Line) shapes.get(2);
        assertEquals(180.0, line3.getStartX(), 0.1);
        assertEquals(40.0, line3.getStartY(), 0.1);
        assertEquals(240.0, line3.getEndX(), 0.1);
        assertEquals(280.0, line3.getEndY(), 0.1);

        Line line4 = (Line) shapes.get(3);
        assertEquals(90.0, line4.getStartX(), 0.1);
        assertEquals(180.0, line4.getStartY(), 0.1);
        assertEquals(389.0, line4.getEndX(), 0.1);
        assertEquals(240.0, line4.getEndY(), 0.1);

        Arc arc = (Arc) shapes.get(4);
        assertEquals(100.0, arc.getCenterX(), 0.1);
        assertEquals(100.0, arc.getCenterY(), 0.1);
        assertEquals(100.0, arc.getRadiusX(), 0.1);
        assertEquals(100.0, arc.getRadiusY(), 0.1);
        assertEquals(0.0, arc.getStartAngle(), 0.1);
        assertEquals(40.0, arc.getLength(), 0.1);
    }
}