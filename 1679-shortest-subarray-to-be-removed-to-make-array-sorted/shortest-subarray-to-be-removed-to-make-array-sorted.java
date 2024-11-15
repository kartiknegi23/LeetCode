class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int j = arr.length-1;
        
        int idx = arr.length-1;
        while(idx>0){
            if(arr[idx]>=arr[idx-1])
            j--;
            else
            break;
            idx--;
        }

        System.out.println(j);

        int i=0;
        int length = j;

        while(i<j && (i==0 || arr[i]>=arr[i-1])){
            while(j<arr.length && arr[i]>arr[j]){
                j++;
            }

            length = Math.min(length, j-i-1);

            i++;
        }

        return length;
    }
}