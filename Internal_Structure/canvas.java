package Internal_Structure;
import java.util.ArrayList;
import java.util.Arrays;


public class canvas {

    public int[] size = new int []{5, 5};//the size coule be changed
    public int[][] status [] = new int[size[0]][size[1]][];



    public void create_canvas() {
//        int[][] status[] = new int[size[0]][size[1]][];
        // small setup for showing, could be bigger by changing the numb
        // creat array storing status
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                status[i][j] = new int[]{0, 0, 0};
            }
        }
    }


    public static boolean checkDup(int[] target, ArrayList<int[]> coordinate){
        for (int i = 0; i < coordinate.size(); i++){
            if (Arrays.equals(target, coordinate.get(i))){return true;}
        }
        return false;
    }

// test runs
    public static void main(String args[]) {
        canvas canvas = new canvas(); // create an instance of DotsPosition
        canvas.create_canvas();
//        canvas.test(); // call the test method
        System.out.println(Arrays.toString(canvas.status[0][0]));
    }




//    public void test() {
//        create_canvas();
//        //test the availability
//        System.out.println("print the canvas------------------------");
//        for(int i=0; i<status.length; i++){
//            for(int j=0; j<status[0].length; j++){
//                System.out.print(Arrays.toString(status[i][j])+"\t");
//            }
//            System.out.println();
//        }
//        System.out.println("print test------------------------");
//
//
//
//        int[] a = status[1][1];
//        int[] b = status[2][2];
//
//        int[] c = new int[a.length];
//        int index = 0;
//
//        for (int i : a) {
//            for (int j : b) {
//                c[index] = i + j;
//                b = Arrays.copyOfRange(b, 1, b.length);
//                index = index + 1;
//                break;
//            }
//        }
//        System.out.println(Arrays.toString(c));
//        //coordinate with status successfully stored in Integer form
//        //capable of doing calculation based on it
//        System.out.println(Arrays.toString(status[0][0]));
//
//    }

}
