/**
 * @param {number[]} nums
 * @return {number}
 */
 var removeDuplicates = function(nums) {
  if (nums.length === 0) return 0;
  if (nums.length === 1) return 1;
  let count = 1
  for (let i=1; i<nums.length; i++) {
      const prev = nums[i-1];
      const cur = nums[i];
      if (prev === cur) {
          // do nothing
      } 
      if (prev < cur) {
          nums[count] = cur
          count += 1
      }

  }
  return count;
};