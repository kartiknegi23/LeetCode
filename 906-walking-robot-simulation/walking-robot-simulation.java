class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x=0;
        int y=0;
        int up = 1;
        int down = 0;
        int left = 0;
        int right = 0;
        int maxDistance = Integer.MIN_VALUE;
        Set<String> set= new HashSet<>();

        for(int i=0;i<obstacles.length;i++){
            int a = obstacles[i][0];
            int b = obstacles[i][1];

            String str = a+"_"+b;
            set.add(str);
        }


        for(int i=0;i<commands.length;i++){
            if(commands[i]==-2){
                if(up==1)
                {
                    up=0;
                    left=1;
                }
                else if(left==1)
                {
                    left=0;
                    down=1;
                }
                else if(down==1)
                {
                    down=0;
                    right=1;
                }
                else{
                    right=0;
                    up=1;
                }
            }

            else if(commands[i]==-1){
                if(up==1)
                {
                    up=0;
                    right=1;
                }
                else if(left==1)
                {
                    left=0;
                    up=1;
                }
                else if(down==1)
                {
                    down=0;
                    left=1;
                }
                else{
                    right=0;
                    down=1;
                }
            }

            else{
                while(commands[i]>0){
                       
                    int prevx = x;
                    int prevy = y;               

                    if(up==1){
                        y++;
                    }
                    else if(right==1){
                        x++;
                    }
                    else if(down==1){
                        y--;
                    }
                    else{
                        x--;
                    }
                    commands[i]--;

                    String s = x+"_"+y;
                    
                    if(set.contains(s))
                    {   
                        x = prevx;
                        y = prevy;
                        System.out.println("hello");
                        break; 
                    } 

                    maxDistance = Math.max(maxDistance, (x*x+y*y));
                    
                }
                
            }
        }

        return maxDistance!=-2147483648 ? maxDistance : 0;
    }
}