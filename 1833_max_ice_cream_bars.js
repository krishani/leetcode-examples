/**
 * @param {number[]} costs
 * @param {number} coins
 * @return {number}
 */

 const getMaxNumIceCream = function(costArr, sum) {
  if (sum === 0) {
      return 0;
  }
  if (sum < 0) {
      return Number.MIN_VALUE; 
  }
  if (costArr.length === 0) {
      return 0;
  }
  if (costArr.length === 1 && sum >= costArr[0]) {
      return 1;
  } 
  let maxNum = Number.MIN_VALUE;
  for (let i = 0; i< costArr.length; i++) {
      if (sum - costArr[i] >=0) {
          const numIceCreamFromGivenArr = 1 + getMaxNumIceCream(costArr.slice(i + 1, costArr.length), sum - costArr[i]);
          if (numIceCreamFromGivenArr > maxNum) {
              maxNum = numIceCreamFromGivenArr;
          }
      } else {
          const nextIceCream = getMaxNumIceCream(costArr.slice(i + 1, costArr.length), sum);
          if (nextIceCream > maxNum) {
              maxNum = nextIceCream;
          }
      }
  }
  return maxNum;
}

var maxIceCream = function(costs, coins) {
  var memo = Array(costs.length).fill();
  console.log(memo);
// [  [6], [6], [6]  ]
  /*const memo = []; // this is an array starting with index -1, 0, 1, 2....... till the number of coins
  memo[0] = Number.MIN_VALUE;  // represents negative
  memo[1] = 0; // represents // 0

  for (let i = 1; i<=coins; i++) {
      let max = Number.MIN_VALUE;

      costs.forEach(cost => {
          const index = (i - cost) < 0 ? 0 : (i - cost + 1);
          const temp = memo[index] + 1;
          if (temp > max) {
              max = temp;
          }
      })
      if (max < 0) {
          max = 0;
      }
      memo[i] = max;
      
      console.log('i ------> ', i , '---->', memo[i]);
  }
  return memo[coins]*/

  return getMaxNumIceCream(costs, coins);
};