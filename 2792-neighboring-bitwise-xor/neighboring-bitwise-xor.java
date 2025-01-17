class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length; 
        int[] original = new int[n];
        for(int i=1;i<n;i++){
            if(derived[i-1] == 1){
                original[i] = 1-original[i-1];
            }
            else{
                original[i] = original[i-1];
            }
        }

        if(derived[n-1] == 0){
            if(original[0] == original[n-1])
            return true;

            else
            return false;
        }

        else{
            if(original[0] == original[n-1])
            return false;

            else
            return true;
        }
    }
}