import java.util.Arrays;

public class sortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        int target = 56;

        System.out.println(Arrays.toString(search(arr, target)));
    }

    // binary search in the specific row and column
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target){
        while(cStart <= cEnd){
            int mid = cStart + (cEnd - cStart) / 2;
            if(target == matrix[row][mid]){
                return new int[]{row, mid};
            }
            else if(target < matrix[row][mid]){
                cEnd = mid - 1;
            }
            else{
                cStart = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    static int[] search(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;  // be cautious, matrix maybe empty

        // if there is only one row in the matrix
        if(rows == 1){
            return binarySearch(matrix, 0, 0, cols-1, target);
        }

        // run the loop till 2 rows are remaining
        //initialing the variables
        int rStart = 0;
        int rEnd = rows - 1;
        int mCols = cols / 2;

        while(rStart < (rEnd - 1)) {  // while this is true it will have more than 2 rows
            int mRow = rStart + (rEnd - rStart) / 2;

            //3 cases to reduce the rows
            if(target == matrix[mRow][mCols]) {
                return new int[]{mRow, mCols};
            }
            if(target < matrix[mRow][mCols]) {
                rEnd = mRow;
            }
            else{
                rStart = mRow;
            }
        }

        // now after above loop we have 2 rows left in our bucket
        // check whether the target element is in the mcol of 2 rows
        if(matrix[rStart][mCols] == target){
            return new int[]{rStart, mCols};
        }
        if(matrix[rStart + 1][mCols] == target){
            return new int[]{rStart + 1, mCols};
        }

        //otherwise search in 1st half
        if(target <= matrix[rStart][mCols - 1]){
            return binarySearch(matrix, rStart, 0, mCols, target);   // here rStart work as rows and cStart is like index in rStrat row from where to start
        }

        //otherwise search in 2nd half
        if(target >= matrix[rStart][mCols + 1] && target <= matrix[rStart][cols-1]){
            return binarySearch(matrix, rStart, mCols + 1, cols - 1 , target);
        }

        //otherwise search in 3rd half
        if(target <= matrix[rStart + 1][mCols - 1]){
            return binarySearch(matrix, rStart + 1, 0, mCols, target);
        }

        //otherwise search in 4th half
        else{
            return binarySearch(matrix, rStart + 1, mCols + 1, cols - 1, target);
        }

    }
}
