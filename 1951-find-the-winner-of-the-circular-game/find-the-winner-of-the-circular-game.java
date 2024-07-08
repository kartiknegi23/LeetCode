class Solution {
    public int findTheWinner(int n, int k) {

        List<Integer>list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        while(list.size()>=2){
            int count = 0;
            for(int i=0;i<list.size();i++){
                count++;
                if(count==k && list.size()>=2){
                    list.remove((int) i);
                    count=0;
                    i--;
                }

                if(list.size()>=2 && i==(list.size()-1))
                i=-1;
            }
        }

        return list.get((int) 0);
    }
}