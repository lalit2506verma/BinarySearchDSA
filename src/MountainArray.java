public class MountainArray {
    public static void main(String[] args){

    }

    //highest number in the mountain array
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid + 1]){
                //this case will execute when mid is in decreasing part of the array
                // it might be possibilty that answer will lie in left hand side of the mid
                end = mid;
            }
            else {
                // this case will execute when mid is in the increasing part of the array
                // it might be the possibility that answer will lie in the right side if the mid;
                start = mid + 1;  // adding "1" because we already know arr[mid+1] > arr[mid]
            }
        }

        // int the end, start == end and pointing to the largest number because of the two checks above
        return end; // you can return start also
    }
}
