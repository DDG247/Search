public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 11, 11,13, 15, 17, 19 };  // 示例数组
        int target = 11;  // 要查找的目标值
        int n = arr.length;  // 数组的长度
        // 测试递归实现
        int resultRecursive = binarySearch(arr, 0, n - 1, target);
        if (resultRecursive != -1) {
            System.out.println("Element " + target + " found at index " + resultRecursive + " using recursive binary search.");
        }
        else {
            System.out.println("Element " + target + " not found using recursive binary search.");
        }
    }

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if(left>right){
            return -1;
        }
        int mid = (left + right)/2;
        if(arr[mid]==target){
            return mid;
        }
        else if(arr[mid]>target){
            return binarySearch(arr,left,mid-1,target);
        }
        else{
            return binarySearch(arr,mid+1,right,target);
        }
        }
    }
