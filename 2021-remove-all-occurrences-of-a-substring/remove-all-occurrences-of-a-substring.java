class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        int n = part.length();

        for(int i=0;i<s.length();i++){
            str.append(s.charAt(i));

            if(str.length()>=n && str.charAt(str.length()-1) == part.charAt(part.length()-1)){
                boolean flag = true;
                for(int j=0;j<n;j++){
                    if(str.charAt(str.length()-n+j) != part.charAt(j)){
                        flag =false;
                        break;
                    }
                }
                if(flag==true){
                    int len = n;
                    while(len>0){
                        str.deleteCharAt(str.length()-1);
                        len--;
                    }
                }
            }
        }

        return str.toString();
    }
}