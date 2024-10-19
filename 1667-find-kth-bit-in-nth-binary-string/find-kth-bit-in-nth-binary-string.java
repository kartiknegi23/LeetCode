class Solution {
    public void solve(int current, int n, StringBuilder[] str, int k){
        if(current>=n)
        return;

        str[current] = new StringBuilder(str[current-1]);
        str[current].append("1");
        StringBuilder inv = new StringBuilder(reverseInvert(str[current-1]));
        str[current].append(inv);

        if(k<=str[current].length())
        return;

        solve(current+1, n, str, k);
    }

    public StringBuilder reverseInvert(StringBuilder str){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0')
            str.setCharAt(i, '1');

            else
            str.setCharAt(i, '0');
        }

        str.reverse();
        return str;
    }

    public char findKthBit(int n, int k) {
        StringBuilder[] str = new StringBuilder[n];
        str[0] = new StringBuilder("0");

        solve(1, n, str, k);

        for(int i=n-1;i>=0;i--){
            if(str[i]!=null)
            return str[i].charAt(k-1);
        }

        return '0';
    }
}