class Solution {

    // need a hashset to keep the already found values
    // if not will get the 
    Set<Integer> alreadySeenSet = new HashSet();

    public int getSquareSum(int n) {
        String convertedToString = String.valueOf(n);
        int sum = 0;
        for (int i=0; i<convertedToString.length(); i++) {
            char numChar = convertedToString.charAt(i);
            int num = Integer.parseInt(String.valueOf(numChar));  
            sum += Math.pow(num, 2);
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int sum = n;
        while (!((alreadySeenSet.contains(sum) == true) || sum == 1 )) {
            alreadySeenSet.add(sum);
            sum = getSquareSum(sum);
        }
        if (sum == 1) return true;
        return false;
    }
}