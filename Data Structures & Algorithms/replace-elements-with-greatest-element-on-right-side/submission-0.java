class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        // int[] res = new int[n];
        // res[n-1] = -1;
        int currMax = arr[n-1];
        int currEl = arr[n-1];
        arr[n-1] = -1;

        for(int i = n - 2; i >= 0; i--) {
            if(currEl > currMax) {
                currMax = currEl;
            }
            currEl = arr[i];
            arr[i] = currMax;
        }

        return arr; 
    }
}