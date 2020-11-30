package com.zipcodewilmington.arrayutility;

import javax.rmi.CORBA.Util;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {
    private T[] inputArray;

    public ArrayUtility(T[] inputArray){
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        List<T> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(arrayToMerge));
        arrayList.addAll(Arrays.asList(inputArray));
        return Collections.frequency(arrayList, valueToEvaluate);
        }


    public T getMostCommonFromMerge(T[] arrayToMerge) {
        Integer mostCommon = Integer.MIN_VALUE;
        List<T> arrayList = new ArrayList<>();
        T mostCommonVal = null; //most common val doesn't exist, go thru and get it
        arrayList.addAll(Arrays.asList(arrayToMerge));
        arrayList.addAll(Arrays.asList(inputArray));
        for (T t : arrayList) {
            Integer current =  Collections.frequency(arrayList, t);
            if (current > mostCommon) {
                mostCommon = current;
                mostCommonVal = t;
            }
                }
            return mostCommonVal;
        }

        //List<T> arrayList = new ArrayList<>();
    // arrayList.addAll(Arrays.asList(arrayToMerge));
    // arrayList.addAll(Arrays.asList(inputArray));
    // return arrayList.stream().collect(Collectors.groupingBy(Function.identity(), //identifying what is in it
    // Collectors.counting())).entrySet().stream()
    // .max(Map.Entry.comparingByValue()).get().getKey();


    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        List<T> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(inputArray));
        return Collections.frequency(arrayList, valueToEvaluate);

    }

    public T[] removeValue(T valueToRemove) {
        int numOccurrences = getNumberOfOccurrences(valueToRemove);
        T[] results = Arrays.copyOf(inputArray, inputArray.length - numOccurrences);

        for (int i = 0, j = 0; i < inputArray.length; i++) {
            if (inputArray[i] != valueToRemove){
                results[j] = inputArray[i];
                j++;
            } // j is counting up index in new array and filling it, i goes thru original
            } // checking index of input array, if it's not the val we want to remove, we put it in j and increase index of j to the next one to fill

        return results;
    }
}
