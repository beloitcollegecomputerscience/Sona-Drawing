package LineStructure

import javafx.geometry.Point2D;
import javafx.scene.shape.LineTo;

public class LineSegment extends LineTo {
    public LineSegment(Point2D end){
        super(end.getX(), end.getY());
    }
}
