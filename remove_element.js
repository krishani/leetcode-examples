
/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
 var removeElement = function(nums, val) {
  let leftPtr = 0;
  let rightPtr = nums.length -1;
  let count = 0;

  while(leftPtr <= rightPtr) {
      if (nums[leftPtr] === val) {
          if (nums[rightPtr] === val) {
              rightPtr -= 1;
              count += 1;
          } else {
              // TODO swap
              let temp = nums[rightPtr];
              nums[rightPtr] = nums[leftPtr];
              nums[leftPtr] = temp;
              rightPtr -= 1;
              leftPtr += 1;
              count +=1
          }
      } else {
          leftPtr += 1;
      }
  }
  return nums.length - count;
};