/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginsystem;

/**
 * Author: Alan Li
 * Class: ICS4U
 * Program: Sorting Assignment (Bubble Sorting)
 * 
 */
public class BubbleSorting {
    
    /**
     * Sorts an array of integers using the bubble sort method
     * @param array, the array of integers that's going to be sorted
     */
    public static void bubbleSort(int[] array) {
        
        //sets the length of the array to n
        int n = array.length;
        
        //loops through the array
        for (int i = 0; i < n - 1; i++){
            //loops through the unsorted portion of the array
            for (int j = 0; j < n-1-i; j++) {
                //compares adjacent elements to see if element in array[j] is bigger than the element after
                if (array[j] > array[j+1]){
                    //swaps if the element is greater than the element after
                    //takes array[j] and stores in temp
                    int temp = array[j];
                    //makes array[j+1] equal to the position of array[j]
                    array[j] = array[j+1];
                    //makes array[j] equal to the position of array[j+1]
                    array[j+1] = temp;
                }
            }
        }
    }
}
