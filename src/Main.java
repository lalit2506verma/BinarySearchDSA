public class Main {
    public static void main(String[] args) {

        //int[] arr = {-23, -15, -1, 0, 2, 5, 23, 38, 56, 77, 100};
        int target = -1;
        //System.out.println(search(arr, target));

        int[] arr2 = {100, 77, 56, 38, 23, 5, 2, 0, -1, -15, -23};
        System.out.println(search2(arr2, target));
    }

    // code for the acsending order
    //return the index
    //return -1 if not exist
    static int search(int[] arr, int target){
        int start = 0;
        int end = arr.length;

        while(start <= end){
            // find the middle value
            //int mid = (start + end) / 2;    might be possible (start + end) value will exceeds the value of int in java

            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }
            else if(target < arr[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }

        }
        return -1;
    }


    //code for the desending order

    static int search2(int[] arr, int target){
        int end = arr.length;
        int start = 0;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target == arr[mid]){
                return mid;
            }
            else if(target > arr[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
}