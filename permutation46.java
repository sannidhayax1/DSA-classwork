class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isValid = new boolean[nums.length];
        helper(nums, new ArrayList<>(), isValid, ans);
        return ans;
    }

    public void helper(int[] nums, List<Integer> ds, boolean[] isValid, List<List<Integer>> ans) {
        int n = nums.length;

        if (ds.size() == n) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isValid[i]) continue;

            ds.add(nums[i]);
            isValid[i] = true;

            helper(nums, ds, isValid, ans);

            isValid[i] = false;
            ds.remove(ds.size() - 1);
        }
    }
}