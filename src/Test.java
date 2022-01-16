import java.util.Arrays;

public class Test {
    public static void fillZigZag(int[][] arr){
        int counter  = 1;
        for (int row = 0; row < arr.length ; row ++){
            if (row % 2 == 0){
                for (int col = 0; col < arr[0].length ; col ++){
                    arr[row][col] = counter;
                    counter ++;
                }
            }else {
                for (int col = arr.length - 1; col >= 0 ; col --){
                    arr[row][col] = counter;
                    counter ++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[3][3];
        fillZigZag(array);
        for (int[] row: array)
            System.out.println(Arrays.toString(row));
    }
}
