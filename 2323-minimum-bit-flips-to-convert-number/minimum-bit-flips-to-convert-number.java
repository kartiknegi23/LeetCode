class Solution {
    public int minBitFlips(int start, int goal) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        while(start>0){
            int remainder = start%2;
            str1.append(remainder);
            start/=2;
        }
        str1 = str1.reverse();

        while(goal>0){
            int remainder = goal%2;
            str2.append(remainder);
            goal/=2;
        }
        str2 = str2.reverse();

        System.out.println(str1);
        System.out.println(str2);

        int count = 0;
        int diff = Math.abs(str1.length()-str2.length());
        
        StringBuilder big = new StringBuilder();
        StringBuilder small = new StringBuilder();
        if(diff!=0){

            big =  str2.length() > str1.length() ? str2 : str1;
            small = str2.length() < str1.length() ? str2 : str1;

            for(int i=0;i<diff;i++){
                if(big.charAt(i)=='1')
                count++;
            }

            for(int i=0;i<small.length();i++){
                if(small.charAt(i)!=big.charAt(diff+i))
                {   
                    count++;
                }
            }
        }

        else
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i))
            count++;
        }

        return count;
    }
}