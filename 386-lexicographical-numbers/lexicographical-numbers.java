class Solution {
    public void solve(int current, int n, List<Integer> result){
        if(current>n)
        return;

        result.add(current);

        for(int i=0;i<=9;i++){
            int new_num = current*10+i;
            solve(new_num, n, result);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer>result = new ArrayList<>();

        for(int i=1;i<=9;i++){
            solve(i, n, result);
        }
        
        return result;
    }
}