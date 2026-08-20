/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        return binarySearch(0, reader.length() - 1, reader);
    }

    private int binarySearch(int l, int r, ArrayReader reader) {
        if(l >= r) {
            return l;
        }

        int mid = (l + r) / 2;
        int length = (r - l + 1);

        if (length % 2 == 1) {
            int res = reader.compareSub(l, mid - 1, mid + 1, r);
            if (res == 0) return mid;
            if (res < 0) return binarySearch(mid + 1, r, reader);
            return binarySearch(l, mid - 1, reader);
        } else {
            int res = reader.compareSub(l, mid, mid + 1, r);
            if (res < 0) return binarySearch(mid + 1, r, reader);
            return binarySearch(l, mid, reader);
        }
    }
}