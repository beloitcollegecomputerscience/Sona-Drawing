package LineStructure

import javafx.geometry.Point2D;
import javafx.scene.shape.ArcTo;

public class CircularArc extends ArcTo {

    private static final double DEFAULT_RADIUS_X = 100.0;
    private static final double DEFAULT_RADIUS_Y = 100.0;

    public CircularArc(Point2D end){
        super();
        setRadiusX(DEFAULT_RADIUS_X);
        setRadiusY(DEFAULT_RADIUS_Y);
        setLargeArcFlag(false);
        setSweepFlag(false);
        setX(end.getX());
        setY(end.getY());
    }
}
