package Internal_Structure;

import java.util.ArrayList;
import java.util.Arrays;

public class WallsPosition {

    public ArrayList<int[]> walls_coordinate_direction = new ArrayList<>(); // create array storing status
    // [x, y, z] , x,y represent coordinate, z represent horizontal (1) /vertical (2)

    public void add(int[] coordinate, int orientation,int[][] status[]) {
        // Implementation of add function goes here
        if (coordinate[0] % 2 == 1 && coordinate[1] % 2 == 1) {
                    if  (!canvas.checkDup(new int[]{coordinate[0] , coordinate[1], orientation}, walls_coordinate_direction)){
                        walls_coordinate_direction.add(new int[]{coordinate[0], coordinate[1], orientation});
                        status[coordinate[0]][coordinate[1]][1] = orientation;
                    }

                }


    }



    public void delete(int[] target, int[][] status[]) {
        // Implementation of add function goes here
        if (target[0] % 2 == 1 && target[1] % 2 == 1) {
            for (int i = 0; i < walls_coordinate_direction.size(); i++){
                if (Arrays.equals(target, new int[] {walls_coordinate_direction.get(i)[0],walls_coordinate_direction.get(i)[1]})){
                    walls_coordinate_direction.remove(i);
                    status[target[0]][target[1]][1] = 0;
                }
            }
        }
    }



}
