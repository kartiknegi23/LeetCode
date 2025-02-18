class Solution {
    String ans;
    public void getPerm(StringBuilder str, int[] arr, int n, StringBuilder current, String pattern){
        if(current.length() == n)
        {
            boolean flag = true;
            for(int i=0;i<pattern.length();i++){
                if((pattern.charAt(i) == 'I' && current.charAt(i)>current.charAt(i+1)) || (pattern.charAt(i) == 'D' && current.charAt(i) < current.charAt(i+1)))
                {
                    flag = false;
                    break;
                }
            }
            if(flag==true)
            {
                if(ans == null)
                ans = current.toString();

                else
                ans = (current.toString().compareTo(ans) < 0) ? current.toString() : ans;
            }
        }

        for(int i=1;i<=n;i++){
            if(arr[i-1] == 1)
            continue;

            //take//
            arr[i-1] = 1;
            current.append(Integer.toString(i));
            getPerm(str, arr, n, current, pattern);
            

            //skip//
            arr[i-1] = 0;
            current.deleteCharAt(current.length()-1);
        }

        return;
    }

    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder str = new StringBuilder();
        StringBuilder current = new StringBuilder();
        int[] arr = new int[n+1];

        for(int i=1;i<=n+1;i++){
            str.append(Integer.toString(i));
        }

        getPerm(str, arr, n+1, current, pattern);

        return ans;
    }
}