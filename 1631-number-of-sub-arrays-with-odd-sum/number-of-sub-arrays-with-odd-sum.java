class Solution {
    double MOD = 1e9+7;

    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];

        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        int odd_count = 0;
        int even_count = 1;
        int result = 0;

        for(int i=0;i<n;i++){
            if(prefix[i]%2==0){
                result =(int) ((result + odd_count)%MOD);
                even_count++;
            }

            else{
                result =(int) ((result + even_count)%MOD);
                odd_count++;
            }
        }

        return result;
    }
}