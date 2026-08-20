class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[n+m];

        int i = 0, j = 0, res = 0;

        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                sorted[res++] = nums1[i++];
            } else {
                sorted[res++] = nums2[j++];
            }
        }

        while(i < m) {
            sorted[res++] = nums1[i++];
        }

        while(j < n) {
            sorted[res++] = nums2[j++];
        }

        for(i = 0; i < res; i++) {
            nums1[i] = sorted[i];
        }
    }
}