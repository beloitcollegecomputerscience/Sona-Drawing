package src.initialSetup;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Path;
public class lingFunction {

    public Path generateLine(double startX, double startY, double dotSize, int numRows, int numCols) {
        Path path = new Path();
        MoveTo moveTo = new MoveTo(startX, startY);
        path.getElements().add(moveTo);

        double x = startX;
        double y = startY;
        double endX = startX + (numCols - 1) * dotSize;
        double endY = startY + (numRows - 1) * dotSize;

        boolean goingRight = true;
        for (int row = 0; row < numRows; row++) {
            if (goingRight) {
                for (int col = 1; col < numCols; col++) {
                    x += dotSize;
                    if (x > endX) {
                        x = endX;
                        y += dotSize;
                        path.getElements().add(new LineTo(x, y));
                        goingRight = false;
                        break;
                    } else {
                        path.getElements().add(new LineTo(x, y));
                    }
                }
            } else {
                for (int col = numCols - 2; col >= 0; col--) {
                    x -= dotSize;
                    if (x < startX) {
                        x = startX;
                        y += dotSize;
                        path.getElements().add(new LineTo(x, y));
                        goingRight = true;
                        break;
                    } else {
                        path.getElements().add(new LineTo(x, y));
                    }
                }
            }
        }

        return path;
    }

}
