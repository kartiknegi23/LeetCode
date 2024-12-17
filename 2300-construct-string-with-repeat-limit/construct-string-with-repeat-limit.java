class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder str = new StringBuilder();

        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }

        int i = 25;
        while(i>=0){
            if(count[i]==0){
                i--;
                continue;
            }

            char ch = (char) (i+'a');
            int freq = Math.min(count[i], repeatLimit);
            count[i]-=freq;

            while(freq>0)
            {
                str.append(ch);
                freq--;
            }
            

            if(count[i]>0){
                int j=i-1;
                while(j>=0){
                    if(count[j]>0){
                        char cha = (char) (j+'a');
                        str.append(cha);
                        count[j]-=1;
                        break;
                    }
                    j--;
                }

                if(j==-1)
                break;
            }

        }
        return str.toString();
    }
}