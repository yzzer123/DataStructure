package day10;

import java.util.*;

class RandomizedSet {

    List<Integer> arr;
    Map<Integer, Integer> indexMap;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        arr = new ArrayList<>(1000);
        indexMap = new HashMap<>();
        random = new Random();

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        arr.add(val);
        indexMap.put(val, arr.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        int index = indexMap.get(val);
        int last = arr.get(arr.size() - 1);
        arr.set(index, last);
        arr.remove(arr.size() - 1);
        indexMap.put(last, index);
        indexMap.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int randomIndex = random.nextInt(arr.size());
        return arr.get(randomIndex);
    }
}