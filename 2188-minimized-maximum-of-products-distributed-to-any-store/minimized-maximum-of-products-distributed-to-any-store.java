class Solution {
    public boolean isAnswer(int mid, int[] quantities, int n){
        for(int i=0;i<quantities.length;i++){
            n -= (int) Math.ceil((float) quantities[i]/mid);
            if(n<0)
            return false; 
        }
        return true;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int max_element = 0;
        for(int i=0;i<quantities.length;i++){
            max_element = Math.max(max_element, quantities[i]);
        }

        int left = 1;
        int right = max_element;
        int answer = 0;

        while(left<=right){
            int mid = (left+right)/2;

            if(isAnswer(mid, quantities, n)){
                answer = mid;
                right=mid-1;
            }
            else
            left=mid+1;
            
        }
        return answer;
    }
}