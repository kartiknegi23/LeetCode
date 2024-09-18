class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder str = new StringBuilder();
        String[] arr = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = Integer.toString(nums[i]);
        }

        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        };

        Arrays.sort(arr, comp);

        if(arr[0].equals("0"))
        return "0";

        for(int i=0;i<arr.length;i++){
            StringBuilder temp = new StringBuilder(arr[i]);
            str.append(temp);
        }

        String result = str.toString();
        return result;
    }
}