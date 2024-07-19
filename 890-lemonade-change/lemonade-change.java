class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[3];

        for(int i=0;i<bills.length;i++){
            int required = bills[i]-5;
            if(required==0){
                change[0]+=5;
            }

            else if(required==5){
                if(change[0]>=required){
                    change[0]-=5;
                    change[1]+=10;
                }
                else{
                    System.out.println(i);
                    return false;
                }
            }

            else if(required==15){
                if(change[0]>=5 && change[1]>=10){
                    change[0]-=5;
                    change[1]-=10;
                    change[2]+=20;
                    continue;
                }

                else if(change[0]>=15){
                    change[0]-=15;
                    change[2]+=20;
                }

                else
                {
                return false;}
            }
        }

        return true;
    }
}