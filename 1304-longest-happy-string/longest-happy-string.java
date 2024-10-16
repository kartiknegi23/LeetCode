class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((i,j)-> j[1]-i[1]);
        StringBuilder str = new StringBuilder();
        if(a>0)
        queue.offer(new int[]{'a'-'a', a});
        if(b>0)
        queue.offer(new int[]{'b'-'a', b});
        if(c>0)
        queue.offer(new int[]{'c'-'a', c});

        while(queue.size()>0){
            int[] arr = queue.poll();
            int ch = arr[0];
            int count = arr[1];
            char cha = (char) (ch+'a');

            if((str.length()>=2) && (str.charAt(str.length()-1) == cha) && (str.charAt(str.length()-2) == cha) )
            {
                if(queue.size()==0)
                break;

                int[] arr_new = queue.poll();
                int ch_new = arr_new[0];
                int count_new = arr_new[1];

                str.append((char) (ch_new+'a'));
                count_new--;

                if(count_new>0)
                queue.offer(new int[]{ch_new, count_new});
            }
            else{
                str.append((char) (ch+'a'));
                count--;
            }

            if(count>0)
            queue.offer(new int[]{ch, count});

        }    

        String result = str.toString();
        return result;
    }
}