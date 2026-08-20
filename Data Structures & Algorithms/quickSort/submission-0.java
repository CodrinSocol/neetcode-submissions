// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return quickSortHelper(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> quickSortHelper(List<Pair> pairs, int low, int high) {

        if(high-low <= 0) {
            return pairs;
        }


        Pair pivot = pairs.get(high);

        int left = low;

        for(int i = low; i < high; i++) {
            if(pairs.get(i).key < pivot.key) {
                Pair tmp = pairs.get(left);
                pairs.set(left, pairs.get(i));
                pairs.set(i, tmp);
                left++;
            }
        }
        pairs.set(high, pairs.get(left));
        pairs.set(left, pivot);

        quickSortHelper(pairs, low, left - 1);
        quickSortHelper(pairs, left + 1, high);

        return pairs;
    }
}
