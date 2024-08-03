public class InterpolationSearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int target = 13;

        int result = interpolationSearch(array,0, array.length - 1, target );

        if (result != -1) {
            System.out.println("目标值 " + target + " 在数组中的位置是：" + result);
        } else {
            System.out.println("目标值 " + target + " 未在数组中找到。");
        }
    }


    public static int interpolationSearch(int[] arr, int left, int right, int target) {
        if(left>right){
            return -1;
        }
        int pos = left + ((target - arr[left]) * (right - left)) / (arr[right] - arr[left]);
        if(arr[pos]==target){
            return pos;
        }
        else if(arr[pos]>target){
            return interpolationSearch(arr,left,pos-1,target);
        }
        else{
            return interpolationSearch(arr,pos+1,right,target);
        }
    }
}