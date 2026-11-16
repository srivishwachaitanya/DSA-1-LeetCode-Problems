class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> storage = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            storage.put(nums[i], storage.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> res : storage.entrySet()) {
            if(res.getValue() > nums.length/3) result.add(res.getKey());
        }
        return result;
    }
}
