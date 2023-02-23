class Solution {

    public int getNum(int[] digits) {
        int number = 0;
        for (int i=0; i<digits.length; i++) {
            double multiplier = Math.pow(10, (digits.length-1-i));
            number += digits[i] * multiplier;
            
        }
        return number;
    }

    public List<Integer> getArr(int num) {
        int temp = num;
        while (temp >=0) {
            int largeNum = num 
        }
    }

    public int[] plusOne(int[] digits) {
        int x = getNum(digits);
        System.out.println(x);

        int newNum = x + 1;
        return digits;
        
    }
}