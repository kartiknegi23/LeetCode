class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())
        return false;
        
        StringBuilder str = new StringBuilder(s);

        int count = s.length();

        while(count>0){
            if(str.toString().equals(goal))
            return true;

            char first = str.charAt(0);
            str.deleteCharAt(0);
            str.append(first);

            count--;
        }

        return false;
    }
}