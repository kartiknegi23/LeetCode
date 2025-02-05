class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2))
        return true;

        int i=0;
        int j=0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i) != s2.charAt(j))
            {
                count++;
                list.add(i);
            }

            if(count>2)
            return false;

            i++;
            j++;
        }
        
        int counter = 0;

        List<Character> l1 = new ArrayList<>();
        List<Character> l2 = new ArrayList<>();

        for(int k=0;k<list.size();k++){
            l1.add(s1.charAt(list.get(k)));
            l2.add(s2.charAt(list.get(k)));
        }
        
        for(int k=0;k<l1.size();k++){
            boolean find = false;
            for(int l=0;l<l2.size();l++){
                if(l1.get(k) == l2.get(l)){
                    find = true;
                    break;
                }
            }
            if(find == false)
            return false;
        }

        return true;
    }
}