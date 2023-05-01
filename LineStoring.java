import javafx.scene.shape.Line;
import java.util.HashMap;

public class LineStoring {

    public static void main(String[] args) {
        //Creating lines
        Line line1 = new Line(10, 50, 150, 50);
        Line line2 = new Line(10, 100, 150, 100);
        //Creating hashtable and then store the lines
        HashMap<String, Line> lineMap = new HashMap<>();
        lineMap.put("line1", line1);
        lineMap.put("line2", line2);

        // You can retrieve the Line objects using their key
        Line retrievedLine1 = lineMap.get("line1");
        Line retrievedLine2 = lineMap.get("line2");
    }
}
