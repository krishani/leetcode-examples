class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map < Integer, Integer > frequencyByNumberMap = new HashMap < > ();
        for (int i = 0; i < nums.length; i++) {
            if (frequencyByNumberMap.containsKey(nums[i])) {
                int count = frequencyByNumberMap.get(nums[i]) + 1;
                frequencyByNumberMap.put(nums[i], count);
            } else {
                frequencyByNumberMap.put(nums[i], 1);
            }
        }
        

        Map < Integer, List < Integer >> valuesByCount = new HashMap < > ();

        for (int i = 1; i < nums.length + 1; i++) {
            List<Integer> newArr = new ArrayList<>();
            valuesByCount.put(i,newArr);
        }

        for (Map.Entry < Integer, Integer > entry: frequencyByNumberMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            List <Integer> listOfVals = valuesByCount.get(value);

            listOfVals.add(key);
            valuesByCount.put(value, listOfVals);
        }
        
        int[] resultArr = new int[k];

        int tempK = 1;
        int tempCounter = valuesByCount.size();
        
        List<Integer> myTempList = new  ArrayList<>();
        while (tempK <= k) {
            tempK += valuesByCount.get(tempCounter).size();
            List<Integer> numArray = valuesByCount.get(tempCounter);
            myTempList.addAll(numArray);
            tempCounter = tempCounter - 1;
            
        }
        for (int i=0; i<myTempList.size(); i++) {
            resultArr[i] = myTempList.get(i);
        }
        return resultArr;

    }



}