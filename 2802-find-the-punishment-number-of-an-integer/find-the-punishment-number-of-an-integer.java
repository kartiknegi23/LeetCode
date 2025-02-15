class Solution {
    public boolean check(int i, List<Integer> list, int idx, int sum, int vsum){
        if(idx >= list.size()){
            if(sum+vsum == i)
            return true;

            else
            return false;
        }

        int currentDigit = list.get(idx);
        int originalSum = sum;
        int originalVsum = vsum;
        
        //take sum//
        sum = sum + vsum;
        vsum = currentDigit;
        boolean take = check(i, list, idx+1, sum, vsum);
        sum = originalSum;
        vsum = originalVsum; 

        //take in vsum//
        vsum = vsum*10 + list.get(idx);
        boolean leave = check(i, list, idx+1, sum, vsum);
        vsum = originalVsum;

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
        int sum = 0;
        int vsum = 0;

        return check(i, list, 0, sum, vsum);
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