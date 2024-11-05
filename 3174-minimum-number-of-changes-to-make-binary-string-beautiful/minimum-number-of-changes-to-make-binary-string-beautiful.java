class Solution {
    public int minChanges(String s) {
        int count = 0;
        int length = 1;
        char prev = s.charAt(0);

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==prev){
                length++;
                prev = s.charAt(i);
                continue;
            }
            else{
                if(length%2!=0){
                    count++;
                    prev = s.charAt(i-1);
                    length++;
                    continue;
                }
                length=1;
                prev = s.charAt(i);
            }
        }

        return count;
    }
}