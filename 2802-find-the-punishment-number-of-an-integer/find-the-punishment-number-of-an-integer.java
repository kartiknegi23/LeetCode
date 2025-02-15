class Solution {
    public boolean check(int i, int square, List<Integer> list, int idx, int[] sum, int[] vsum){
        if(idx >= list.size()){
            if(sum[0]+vsum[0] == i)
            return true;

            else
            return false;
        }

        int currentDigit = list.get(idx);
        int originalSum = sum[0];
        int originalVsum = vsum[0];
        

        //take sum//
        sum[0] = sum[0] + vsum[0];
        vsum[0] = currentDigit;
        boolean take = check(i, square, list, idx+1, sum, vsum);
        sum[0] = originalSum;
        vsum[0] = originalVsum; 

        //take in vsum//
        vsum[0] = vsum[0]*10 + list.get(idx);
        boolean leave = check(i, square, list, idx+1, sum, vsum);
        vsum[0] = originalVsum;

        return take || leave;
    }

    public boolean isValid(int i, int square){
        List<Integer> list = new ArrayList<>();
        int num = square;
        while(num>0){
            int rem = num%10;
            list.add(rem);
            num/=10;
        }
        Collections.reverse(list);
        int[] sum = new int[1];
        sum[0] = 0;
        int[] vsum = new int[1];
        vsum[0] = 0;

        return check(i, square, list, 0, sum, vsum);
    }

    public int punishmentNumber(int n) {
        int punish = 0;
        for(int i=1;i<=n;i++){
            int square = i*i;
            if(isValid(i, square))
            punish += square;
        }
        return punish;
    }
}