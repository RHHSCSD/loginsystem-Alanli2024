/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginsystem;



/**
 * Author: Alan Li
 * Class: ICS4U
 * Program: Searching Formative Exercise
 * 
 */
public class Searching {
    
    /**
     * binary search method to find matching term in an array
     * @param term, the term we are trying to find
     * @param list, the array we are using to find the term in
     * @return, returns mid if the term is found in the array
     * @return, returns -1 if the term isn't found in the array
     */
    public static int binarySearch(String term, String[] list){
        
    int low = 0; //start of the array index
    int high = list.length; //end of the array index
    int mid = 0; //the middle of the array index

    //
    while (low <= high){
        //calculate the middle of the array index
        mid = (low + high)/2;
        
        //compares the middle term to the middle index
        //if compare result is equal then it gives 0
        //if term is less than middle index it gives -1
        //if term is greater than middle index it gives 1
        int compareResult = term.compareTo(list[mid]);
        
        //term matches the middle number
        //returns middle number
        if (compareResult == 0){
            return mid;
        }
        //if term is less than middle number, updates the high end of the array to search the left half
        else if (compareResult < 0){
            high = mid - 1;
        }
        //if term is greater than middle number, updates the low end of the array to search the top half
        else {
            low = mid + 1;
        }
        }
    //if loop doesn't find number return -1
        return -1;
    }
    
    /**
     * sequence search method to find matching term in an array
     * @param term,the term we are trying to find
     * @param list, the array we are using to find the term in
     * @return, returns i (index of term) if term is found in the array
     * @return, returns -1 if term isn't found in the array
     */
    public static int seqSearch(String term, String[] list){
        //loops through array and sees if the term at that index equals to the term we are comparing
        for (int i = 0; i < list.length; i++){
            if (term.equals(list[i])) {
                return i;
            }
    }
        //if term isn't found return -1
        return -1;
}
}