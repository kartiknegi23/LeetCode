class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        
        for(int i=0;i<details.length;i++){
            char tens = details[i].charAt(11);
            char ones = details[i].charAt(12);
            
            int no = (tens-'0')*10 + (ones-'0');
            if(no>60)
            count++;
        }

        return count;
            
    }
}