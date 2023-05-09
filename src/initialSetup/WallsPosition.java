package initialSetup;

//import apple.laf.JRSUIConstants;
import canvas.canvas_switching;

import java.util.ArrayList;
import java.util.Arrays;

public class WallsPosition {
    public ArrayList<int[]> walls_coordinate = new ArrayList<>(); // create array storing status
    canvas_switching cs = new canvas.canvas_switching();
 // orientation = 0 for vertical and 1 for horizontal
    public void add(int[] WallCoordinate) { // orientation = 0 for vertical and 1 for horizontal
        int[] TopRightWall = cs.PixelCanvas_to_LinesSpots(WallCoordinate);
        int orientation = orientation_finder(TopRightWall);
        int[] false_value = [-1,-1];
        if  ((!checkDup(TopRightWall, walls_coordinate)) &&
                !Arrays.equals(cs.StructuralCanvas_to_PixelCanvas(TopRightWall), false_value)){
            walls_coordinate.add(new int[] {TopRightWall, orientation});}
    }


    public static boolean checkDup(int[] target, ArrayList<int[]> coordinate){
        for (int i = 0; i < coordinate.size(); i++){
            if (Arrays.equals(target, coordinate.get(i)[0,1])){return true;}
        }
        return false;
    }


    public void delete(int[] target) {
        int[] targetwall = cs.PixelCanvas_to_DotsSpots(target);
        // Implementation of add function goes here
        for (int i = 0; i < walls_coordinate.size(); i++){
            if (Arrays.equals(targetwall, walls_coordinate.get(i))){
                walls_coordinate.remove(i);}
        }

    public static int orientation_finder(int [] TopRightWall)   {
        int [] two_points = initialSetup.DotsPosition.two_closest_dots(TopRightWall);
        if (two_points[0][0] == two_points[1][0]){
            return 1; //1 vertical wall, 0 is horizontal wall
        }
        else{
            return 0;
        }
    }
