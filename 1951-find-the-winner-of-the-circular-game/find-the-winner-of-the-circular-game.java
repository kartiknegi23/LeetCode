class Solution {
    public int findTheWinner(int n, int k) {

        List<Integer>list = new ArrayList<>();
        int no_delete = 0;
        for(int i=1;i<=n;i++){
            list.add(i);
        }

            int count = 0;
            for(int i=0;i<list.size();i++){
                if(list.get(i)==0 && i==(list.size()-1) && no_delete<(n-1)){
                    i=-1;
                    continue;
                }
                
                
                else if(list.get(i)==0)
                continue;
                count++;
                if(count==k && no_delete<(n-1)){
                    list.set((int) i, 0);
                    no_delete++;
                    count=0;
                }

                if(no_delete<(n-1) && i==(list.size()-1))
                i=-1;
            }
        
        System.out.println(list);


        for(int i=0;i<list.size();i++){
            if(list.get(i)!=0)
            return list.get(i);
        }
        return -1;
    }
}