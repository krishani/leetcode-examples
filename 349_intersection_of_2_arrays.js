/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
 var intersection = function(nums1, nums2) {
  /*const nums1MapByElement = {}
  const intersectionMapByElement  = {}

  for (let i=0; i<nums1.length; i++) {
      if (!nums1MapByElement[nums1[i]]) {
          nums1MapByElement[nums1[i]] = true
      } 
  }

  for (let i=0; i<nums2.length; i++) {
      if (nums1MapByElement[nums2[i]] && !intersectionMapByElement[nums2[i]]) {
          intersectionMapByElement[nums2[i]] = true
      } 
  }
  return Object.keys(intersectionMapByElement)*/

  const nums1UniqueSet = new Set()
  const answerArr = []

  for (let i=0; i<nums1.length; i++) {
      if (!nums1UniqueSet.has(nums1[i])) {
          nums1UniqueSet.add(nums1[i])
      }
  }

  for (let i=0; i<nums2.length; i++) {
      if (nums1UniqueSet.has(nums2[i])) {
          answerArr.push(nums2[i])
      }
  }
  return [...new Set(answerArr)]

};