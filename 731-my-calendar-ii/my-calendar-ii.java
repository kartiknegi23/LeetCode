class MyCalendarTwo {
    List<int[]> list;
    List<int[]> double_list;
    public MyCalendarTwo() {
        list = new ArrayList<>();
        double_list = new ArrayList<>();  
    }
    
    public boolean book(int start, int end) {

        for(int i=0;i<double_list.size();i++){
            if(start<double_list.get(i)[1] && end>double_list.get(i)[0]){
                return false;
            }                             
        }
        
        if(list.size()==0)
        {
            list.add(new int[]{start, end});
            return true;
        }

        for(int i=0;i<list.size();i++){
            if(start<list.get(i)[1] && end>list.get(i)[0]){
                int x = Math.max(start, list.get(i)[0]);
                int y = Math.min(end, list.get(i)[1]);
                double_list.add(new int[]{x,y});
            }
        }

        list.add(new int[]{start,end});
        return true;
    }
}   

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */