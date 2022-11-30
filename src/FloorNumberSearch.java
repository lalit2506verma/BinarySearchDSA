public class FloorNumberSearch {
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 7, 9, 16, 17, 25};

        int target = 1;
        System.out.println(floorSearch(arr, target));
    }

    static int floorSearch(int[] arr, int target){

        if(target < arr[arr.length - 1]){
            return -1;

        }
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target == arr[mid]){
                return arr[mid];
            }
            else if(target < arr[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return arr[end];
    }
}
