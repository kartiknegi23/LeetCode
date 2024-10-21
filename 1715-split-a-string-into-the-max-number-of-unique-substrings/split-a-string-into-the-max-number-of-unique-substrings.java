class Solution {
    public int solve(int index, String s, HashSet<String> set, StringBuilder str){
        if(index>=s.length())
        return 0;

        str.append(s.charAt(index));
        String temp = str.toString();
        //Split & set doesnt contain string//
        int split = 0;
        if(!(set.contains(temp))){
            set.add(temp);
            split = 1 + solve(index+1, s, set, new StringBuilder());
            set.remove(temp);
        }

        int skip = 0 + solve(index+1, s, set, str);

        return Math.max(split, skip);
    }

    public int maxUniqueSplit(String s) {
        HashSet<String>set = new HashSet<>();
        StringBuilder str = new StringBuilder();
        return solve(0, s, set, str);
    }
}