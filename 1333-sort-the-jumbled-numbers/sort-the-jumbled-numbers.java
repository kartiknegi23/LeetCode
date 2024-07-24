class Solution {

    public int calcmap(int num, int[] mapping){
        if(num<10){
            return mapping[num];
        }

        int mappedvalue = 0;
        int onesvalue = 1;
        while(num>0){
            int lastdigit = num%10;
            mappedvalue+=(mapping[lastdigit]*onesvalue);
            onesvalue*=10;
            num=(int) Math.floor(num/10);
        }
        return mappedvalue;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] value = new int[nums.length];
        List<int[]> list = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int newvalue = calcmap(nums[i], mapping);
            int[] newentry = {newvalue, i};
            list.add(newentry);
        }

        list.sort(Comparator.comparingInt(arr -> arr[0]));

        for (int[] array : list) {
            System.out.println(Arrays.toString(array));
        }

        int[] firstElements = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            int[] array = list.get(i);
            if (array.length > 0) {
                int index = array[1];
                firstElements[i] = nums[index];
            }
        }


        return firstElements;

    }
}