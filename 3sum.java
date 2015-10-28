public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> l = new ArrayList<>();
        if(nums==null || nums.length<3){
            return l;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for(int i = 0; i<length;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = length-1;
            while(start<end){
                if(nums[start]+nums[end]+nums[i]==0){
                    List<Integer> subl = new ArrayList<Integer>();
                    subl.add(nums[i]);
                    subl.add(nums[start]);
                    subl.add(nums[end]);
                    l.add(subl);
                    while(start<i && nums[start]==nums[start+1]) start++;
                    while(i<end && nums[end]==nums[end-1]) end--;
                    start++;
                    end--;
                }else if(nums[start]+nums[end]+nums[i]>0){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return l;
    }
}