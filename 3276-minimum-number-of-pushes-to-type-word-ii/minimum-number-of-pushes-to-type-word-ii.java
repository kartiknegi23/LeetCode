class Solution {
    public int minimumPushes(String word) {
        Integer[] arr = new Integer[26];
        Arrays.fill(arr, 0);
        int result = 0;

        for(int i=0;i<word.length();i++){
            arr[word.charAt(i)-'a']+=1;
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0;i<26;i++){
            int frequency = arr[i];
            int multiplier = (i/8)+1;
            result += (frequency*multiplier);
        }

        return result;
    }
}