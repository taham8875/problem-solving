# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
  element_to_index = {}
  for i in 0..nums.length - 1
    complement = target - nums[i]
    if element_to_index.key?(complement)
      return [element_to_index[complement], i]
    else
      element_to_index[nums[i]] = i
    end
  end
  return [0, 0]
end
