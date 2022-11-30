public class CeilingNumberSearch {
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 7, 9, 16, 17, 25};

        int target = 26;
        System.out.println(ceilingSearch(arr, target));
    }

    //Find the ceiling number of the target element (smallest greater than equal to) in the array
    static int ceilingSearch(int[] arr, int target) {
        if(target > arr[arr.length - 1]){
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target == arr[mid]){
                return arr[mid];
            } else if (target < arr[mid]) {
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return arr[start];
    }
}
