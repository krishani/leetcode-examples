/**
 * @param {string} s
 * @return {number}
 */
 var lengthOfLastWord = function(s) {
  /*let temp = s.length - 1;
  let count = 0;
  while(temp >= 0 && s[temp] === " ") {
      temp -=1;
  }
  while(temp >=0 && s[temp] !== " ") {
      temp = temp -1
      count+= 1;
  }
  return count;*/
  const x = s.trim().split(" ")
  console.log(x)
  return x[x.length-1].length

};