class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count=0;
        Set<Character>set = new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }

        boolean flag = true;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                if(!(set.contains(words[i].charAt(j))))
                {   
                    flag = false;
                    break;
                }
            }
            if(flag==true)
            count++;
            flag = true;
        }

        return count;
    }
}