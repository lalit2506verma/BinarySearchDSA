public class OrderAgnosticsBS {
    public static void main(String[] args) {
        int[] arr = {-23, -15, -1, 0, 2, 5, 23, 38, 56, 77, 100};
        int[] arr2 = {100, 77, 56, 38, 23, 5, 2, 0, -1, -15, -23};
        int target = 100;

        System.out.println(orderAgnosticsBS(arr, target));
    }

    static int orderAgnosticsBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(target == arr[mid]){
                return mid;
            }
            else{
                if(isAsc){
                    if(target < arr[mid]){
                        end = mid - 1;
                    }
                    else{
                        start = mid + 1;
                    }
                }
                else{
                    if(target > arr[mid]){
                        end = mid - 1;
                    }
                    else{
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
