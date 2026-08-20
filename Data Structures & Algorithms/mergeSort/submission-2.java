class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
       if (pairs.isEmpty()) return pairs;
       return helper(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> helper(List<Pair> pairs, int low, int high) {
        if(low >= high) {
            List<Pair> single = new ArrayList<>();
            single.add(pairs.get(low));
            return single;
        }
        
        int mid = (high+low) / 2;

        List<Pair> leftSorted = helper(pairs, low, mid);
        List<Pair> rightSorted = helper(pairs, mid+1, high);

        List<Pair> result = new ArrayList<>();
        int i = 0, j = 0;

        while(i < leftSorted.size() && j < rightSorted.size()) {
            if(leftSorted.get(i).key <= rightSorted.get(j).key) {
                result.add(leftSorted.get(i++));
            } else {
                result.add(rightSorted.get(j++));
            }
        }

        while(i < leftSorted.size()) {
            result.add(leftSorted.get(i++));
        }

        while(j < rightSorted.size()) {
            result.add(rightSorted.get(j++));
        }

        return result;
    }
}