class Solution {
    public long[] sumOfThree(long num) {
        long[] arr = new long[3];
        double result = ((double) num-3)/3; 

        if(result == Math.floor(result)){
            arr = new long[3];
            arr[0]=(long) result;
            arr[1]=(long) result+1;
            arr[2]=(long) result+2;

            return arr;
        }

        return new long[0];
    }
}