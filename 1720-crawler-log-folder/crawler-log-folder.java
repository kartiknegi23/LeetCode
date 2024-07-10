class Solution {
    public int minOperations(String[] logs) {
        int count=0;
        for(int i=0;i<logs.length;i++){
            if(logs[i].equals("../"))
            {   
                System.out.println("hello");
                if(count>0)
                count--;
            }

            else if(logs[i].length()>=2 && logs[i].charAt(logs[i].length()-2)!='.')
                count++;

        }
        return count;
    }
}