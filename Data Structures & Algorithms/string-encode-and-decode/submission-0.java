class Solution {

    public String encode(List<String> strs) {
        StringBuilder b = new StringBuilder();

        for(String s : strs) {
            int len = s.length();

            b.append(len);
            b.append('#');
            b.append(s);
        }
        System.out.println(b.toString());
        return b.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < str.length()) {
            while(j < str.length() && str.charAt(j) != '#') {
                j++;
            }
            System.out.println(str.substring(i, j));
            int len = Integer.parseInt(str.substring(i, j));

            String s = str.substring(j+1, j+1+len);

            result.add(s);
            i = j+len + 1;
            j=i;
        }

        return result;
    }
}
