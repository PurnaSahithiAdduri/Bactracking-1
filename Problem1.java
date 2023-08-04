// Time Complexity :O(2^m+n)
// Space Complexity : O(2^m+n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// this can be solved in bracktracing of chose not choose and for loop iteration


//Choose not choose backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates,target,0,new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int i, List<Integer> path){
        //base
        if(i == candidates.length ||target<0) return;
        if(target == 0){
            result.add(path);
            return;
        }
        //logic

        //choose
        path.add(candidates[i]);
        helper(candidates, target-candidates[i],i,new ArrayList<>(path));
        path.remove(path.size()-1);
        //not choose
        helper(candidates, target,i+1,new ArrayList<>(path));  
    }
}

//For loop recurssion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates,target,0,new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int pivot, List<Integer> path){
        //base
        if(target<0) return;
        if(target == 0){
            result.add(path);
            return;
        }
        //logic
        for(int i=pivot;i<candidates.length;i++){
            path.add(candidates[i]);
            helper(candidates, target-candidates[i],i,new ArrayList<>(path));
            path.remove(path.size()-1);
        }
    }
}