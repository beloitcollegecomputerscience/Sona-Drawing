package LineStructure

import javafx.scene.shape.PathElement;

import java.util.Hashtable;

public class ShapeStorage {
    private Hashtable<String, PathElement> storage = new Hashtable<String, PathElement>();

    public void addArc(String name, CircularArc circularArc) {
        storage.put(name, circularArc);
    }

    public void addLine(String name, LineSegment lineSegment) {
        storage.put(name, lineSegment);
    }

    public PathElement getShape(String name) {
        return storage.get(name);
    }
}
