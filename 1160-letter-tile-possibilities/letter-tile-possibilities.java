class Solution {
    public void solve(String tiles, int[] arr, Set<String> set, StringBuilder str){
        set.add(new String(str.toString()));

        for(int i=0;i<tiles.length();i++){
            if(arr[i]==1)
            continue;

            //take//
            arr[i] = 1;
            str.append(tiles.charAt(i));
            solve(tiles, arr, set, str);
            str.deleteCharAt(str.length()-1);
            
            //skip//
            arr[i] =0;
        }
    }

    public int numTilePossibilities(String tiles) {
        int[] arr = new int[tiles.length()];
        Set<String> set = new HashSet<>();
        StringBuilder str = new StringBuilder();

        solve(tiles, arr, set, str);

        return set.size()-1;
    }
}