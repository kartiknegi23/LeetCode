class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[1690];
        arr[0]=1;
        int i2=0;
        int i3=0;
        int i5=0; 

        for(int i=1;i<1690;i++){
            arr[i] = Math.min(arr[i2]*2, Math.min(arr[i3]*3, arr[i5]*5));

            if(arr[i]==arr[i2]*2)
            i2++;

            if(arr[i]==arr[i3]*3)
            i3++;

            if(arr[i]==arr[i5]*5)
            i5++;
        }

        return arr[n-1];
    }
}