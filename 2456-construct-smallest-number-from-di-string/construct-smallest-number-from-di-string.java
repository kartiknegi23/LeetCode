class Solution {
    public void getPerm(List<StringBuilder> list, StringBuilder str, int[] arr, int n, StringBuilder current){
        if(current.length() == n)
        {list.add(new StringBuilder(current));
        return;}

        for(int i=1;i<=n;i++){
            if(arr[i-1] == 1)
            continue;

            //take//
            arr[i-1] = 1;
            current.append(Integer.toString(i));
            getPerm(list, str, arr, n, current);
            

            //skip//
            arr[i-1] = 0;
            current.deleteCharAt(current.length()-1);
        }
    }

    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder str = new StringBuilder();
        StringBuilder current = new StringBuilder();
        int[] arr = new int[n+1];

        for(int i=1;i<=n+1;i++){
            str.append(Integer.toString(i));
        }

        List<StringBuilder> list = new ArrayList<>();

        getPerm(list, str, arr, n+1, current);

        for(StringBuilder s : list){
            boolean flag = true;
            for(int i=0;i<pattern.length();i++){
                if((pattern.charAt(i) == 'I' && s.charAt(i)>s.charAt(i+1)) || (pattern.charAt(i) == 'D' && s.charAt(i) < s.charAt(i+1)))
                {
                    flag = false;
                    break;
                }
            }
            if(flag==true)
            return s.toString();
        }

        return "";
    }
}