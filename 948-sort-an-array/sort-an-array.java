class Solution {

    public void mergesort(int[] nums, int low, int high) {
        if (low == high)
            return;

        int mid = ((low + high) / 2);

        mergesort(nums, low, mid);
        mergesort(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    public void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high-low + 1];
        int i = 0;
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[i] = nums[left];
                left++;
                i++;
            }

            else {
                temp[i] = nums[right];
                right++;
                i++;
            }
        }

        while (left <= mid) {
            temp[i] = nums[left];
            left++;
            i++;
        }

        while (right <= high) {
            temp[i] = nums[right];
            right++;
            i++;
        }

        System.arraycopy(temp, 0, nums, low, temp.length);

    }

    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        return nums;
    }
}