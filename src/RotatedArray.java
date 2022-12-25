public class RotatedArray {
    public static void main(String[] args){
        int[] arr = {4,5,6,7,0,1,2};

        System.out.println(search(arr, 0));
    }

    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);   // index value
        //in case we do not found the pivot than array in not rotated
        if(pivot == -1){
            //just do simple binary search
            return binarySearch(nums, target, 0, nums.length-1);
        }

        if(nums[pivot] == target){
            return pivot;
        }
        else if(nums[0] <= target){
            return binarySearch(nums, target, 0, pivot-1);
        }
        else {
            return binarySearch(nums, target, pivot+1, nums.length-1);
        }
    }

    static int binarySearch(int[] arr, int target, int start, int end){

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target == arr[mid]){
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


    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            //case:1 if mid > mid + 1   --> there are two sorted array in the RotatedArray but where these arrays meet that two point are desc. order
            //So we check whether that is not the case
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            //case:2 if mid-1 > mid  --> same check as case 1
            if(mid > start && arr[mid-1] > arr[mid]){
                return mid-1;
            }

            // case:3  start > mid --> if arr[mid] is smaller than arr[start] then all element after mid is also smaller so we can ignore that part
            if(arr[start] >= arr[mid]){
                end = mid - 1;
            }

            //case:4 start < mid  --> if arr[mid] is greater than arr[start] then all element before mid is also smaller so we can ignore that part
            // and mid can nerver be pivot if mid is pivot it would have been caught in case 1 & 2
            if(arr[start] < arr[mid]){
                start = mid + 1;
            }

        }
        return -1;
    }
}
