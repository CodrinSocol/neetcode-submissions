class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int diffF = arr[1] - arr[0];
        int diffL = arr[n-1] - arr[n-2];

        int diff = 0;

        if(Math.abs(diffF) > Math.abs(diffL)) {
            diff = diffL;
        } else {
            diff = diffF;
        }

        System.out.println(diff);

        for(int i = 1; i < n; i++) {
            if(Math.abs(arr[i-1] - arr[i]) > Math.abs(diff)) {
                return arr[i-1] + diff;
            }
        }

        return arr[0];
    }
}
