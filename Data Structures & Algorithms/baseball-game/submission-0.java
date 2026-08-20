class Solution {
    public int calPoints(String[] operations) {
        List<Integer> record = new ArrayList<>();
        int i = -1;

        for(String curr : operations) {
            switch (curr) {
                case "D": {
                    Integer prev = record.get(i);
                    record.add(++i, prev * 2);
                    break;
                }
                case "C": {
                    i--;
                    break;
                }
                case "+": {
                    Integer prev1 = record.get(i);
                    Integer prev2 = record.get(i-1);
                    record.add(++i, prev1 + prev2);
                    break;
                }
                default: {
                    Integer newScore = Integer.parseInt(curr);
                    record.add(++i, newScore);
                }
            }
        }
        
        int sum = 0;

        for(int x = 0; x <= i; x++) {
            sum += record.get(x);
        }

        return sum;
    }
}