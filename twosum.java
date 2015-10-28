public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[]{};
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            m.put(nums[i],i);
        }
        for(int i=0; i<nums.length; i++){
            if(m.get(target-nums[i])!=null && i<m.get(target-nums[i])){
                arr = new int[]{i+1,m.get(target-nums[i])+1};
                return arr;
            }
        }
        return arr;
    }
}