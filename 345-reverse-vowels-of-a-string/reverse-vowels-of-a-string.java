class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set= new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        String result = "";

        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i)))
            stack.push(s.charAt(i));
        }

        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i)))
            result+=stack.pop();

            else
            result+=s.charAt(i);
        }

        return result;
    }
}