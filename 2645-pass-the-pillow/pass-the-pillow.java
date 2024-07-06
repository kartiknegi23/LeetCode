class Solution {
    public int passThePillow(int n, int time) {
        if(time<n)
        return time+1;

        int rounds = time/(n-1);
        int remaining = time%(n-1);

        if(rounds%2==1)
        return n-remaining;

        else
        return remaining+1;
    }
}