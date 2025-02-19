class Solution {
    public void getPerm(List<StringBuilder> list, String str, int n, StringBuilder current){
        if(current.length() == n)
        {
            list.add(new StringBuilder(current));
            return;
        }

        for(int i=0;i<3;i++){
            if(current.length()>0 && current.charAt(current.length()-1) == (char) i+'a')
            continue;

            //take//
            current.append((char) (i+'a'));
            getPerm(list, str, n, current);

            current.deleteCharAt(current.length()-1);
        }

        return;
    } 

    public String getHappyString(int n, int k) {
        List<StringBuilder> list = new ArrayList<>();
        String str = "abc";
        StringBuilder current = new StringBuilder();

        getPerm(list, str, n, current);

        if(list.size() < k)
        return "";

        return list.get(k-1).toString();
    }
}