package com.company.Array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Data implements Comparable<Data> {
    int value, count, index;

    public Data(int value, int count, int index){
        this.value = value;
        this.count = count;
        this.index = index;
    }

    public int compareTo(Data obj){
        if (obj.count != this.count)
            return obj.count - this.count;

        return this.index - obj.index;
    }
}

public class SortByFrequencyAndIndex {

    public static void sortByFrequencyAndIndex(int[] nums)
    {
        Map<Integer, Data> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            map.putIfAbsent(nums[i], new Data(nums[i], 0, i));
            map.get(nums[i]).count++;
        }

        List<Data> list = map.values().stream().sorted().collect(Collectors.toList());

        int j = 0;
        for (Data data : list){
            for (int k = 0; k < data.count; k++)
                nums[j++] = data.value;
        }

    }
}
