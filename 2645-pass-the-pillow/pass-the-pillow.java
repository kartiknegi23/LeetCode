class Solution {
    public int passThePillow(int n, int time) {
        if(time<n)
        return time+1;

        boolean front = true;
        int result=0;
        int count = 0;
        while(count<time){
            if(front==true)
            {
                for(int i=2;i<=n;i++){
                    count++;
                    result=i;
                    if(count>=time)
                    return result;
                }
                front=false;
            }

            else{
                for(int i=n-1;i>=1;i--){
                    result = i;
                    count++;
                    if(count>=time)
                    return result;
                }
                front=true;
            }
        }
        return result;
    }
}