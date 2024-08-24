class Solution {

    public long find_nearest(long num, boolean isEven){
        long n = num;
        if(isEven==false)
        num/=10;

        while(num>0){
            long digit = num%10;
            n = n*10 + digit;
            num/=10;
        }

        return n;
    }

    public String nearestPalindromic(String n) {
        Long num = Long.parseLong(n);
        long len = n.length();

        long mid = (len)%2==0 ? (len)/2 : ((len)/2) + 1;

        String first_half = n.substring(0,(int) mid);
        long firsthalf = Long.parseLong(first_half);

        long[] arr = new long[5];

        arr[0] = find_nearest(firsthalf, (len)%2==0);
        arr[1] = find_nearest(firsthalf+1, (len)%2==0);
        arr[2] = find_nearest(firsthalf-1, (len)%2==0);
        arr[3] = (long) Math.pow(10, len) + 1;
        arr[4] = (long) Math.pow(10, len-1) - 1;

        System.out.print(Arrays.toString(arr));

        long diff = Integer.MAX_VALUE;
        long result = Integer.MAX_VALUE;

        for(long element : arr){
            if(element == num)
            continue;

            if( Math.abs(num - element) < diff){
                diff = Math.abs(num - element);
                result = element;
            }

            else if(num-element == diff)
            result = Math.min(result, element);

        }

        return Long.toString(result);
    }
}