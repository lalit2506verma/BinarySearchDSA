public class InfiniteArray {
    public static void main(String[] args){
        int[] arr = {2, 3, 4, 6, 8, 16, 19, 20, 29, 33, 37, 55, 59, 89, 200};
        int target = 200;

        System.out.println(ans(arr,target));
    }

    static int ans(int[] arr, int target){
        // initializing start and end
        int start = 0;
        int end = 1;

        //condition for the target to lie in the range
        // increasing the size of the array until arr[end] is greater than target element
        while(target > arr[end]){
            int temp = end + 1; // this is my new start

            //now doubling the size of the box
            // end = privious_end + size of box * 2;
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        // now we got the box range where target element would be found
        return binarySearch(arr, target, start, end);

    }

    static int binarySearch(int[] arr, int target, int start, int end){

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(target == arr[mid]){
                return mid;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return -1;
    }
}
