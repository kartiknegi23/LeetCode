class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())
        return false;
        
        int count = s.length();
        String str = s+s;

        for(int i=0;i<s.length();i++){
            String st = str.substring(i,i+count);
            if(st.equals(goal))
            return true;
        }        

        return false;
    }
}