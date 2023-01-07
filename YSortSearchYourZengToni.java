/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ysortsearchyourzengtoni;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tonizeng
 */
public class YSortSearchYourZengToni {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean load = false;
        boolean run = true;

        while (run == true) {

            System.out.printf("OPTION: 1 -  Read Names from File and display the list\n "
                    + "\t2 -  Selection Sort Ascending and display the list\n "
                    + "\t3 -  Selection Sort Descending and display the list\n "
                    + "\t4 -  Bubble Sort Ascending and display the list\n"
                    + "\t5 -  Bubble Sort Descending and display the list\n"
                    + "\t6 -  Insertion Sort Ascending and display the list\n"
                    + "\t7 -  Insertion Sort Descending and display the list\n"
                    + "\t8 -  Binary Search \n"
                    + "\t9 -  Exit\n \t"
                    + "\n\tYour Choice: ");

            String menuOption = sc.nextLine();

            switch (menuOption) {
                case "1": // Read Names from File and display the list
                    readNames();
                    load = true;
                    printArrayList(readNames());
                    break;
                case "2": // Selection Sort Ascending and display the list
                    if (load == false) {
                        System.out.println("Please input option #1 to load the file first.");
                    } else {
                        printArrayList(selectionSortAscending(readNames())); // sort array
                    }
                    break;
                case "3": // Selection Sort Descending and display the list
                    if (load == false) {
                        System.out.println("Please input option #1 to load the file first.");
                    } else {
                        printArrayList(selectionSortDescending(readNames())); // sort array
                    }
                    break;
                case "4": // Bubble Sort Ascending and display the list
                    if (load == false) {
                        System.out.println("Please input option #1 to load the file first.");
                    } else {
                        printArrayList(bubbleSortAscending(readNames())); // sort array
                    }
                    break;
                case "5": // Bubble Sort Descending and display the list

                    if (load == false) {
                        System.out.println("Please input option #1 to load the file first.");
                    } else {
                        printArrayList(bubbleSortDescending(readNames())); // sort array
                    }
                    break;
                case "6": // Insertion Sort Ascending and display the list
                    if (load == false) {
                        System.out.println("Please input option #1 to load the file first.");
                    } else {
                        printArrayList(insertionSortAscending(readNames())); // sort array
                    }
                    break;
                case "7": // Insertion Sort Descending and display the list
                    if (load == false) {
                        System.out.println("Please input option #1 to load the file first.");
                    } else {
                        printArrayList(insertionSortDescending(readNames())); // sort array
                    }
                    break;
                case "8": // Binary Search
                    boolean validStr = false;
                    if (load == false) {
                        System.out.println("Please input option #1 to load the file first.");
                    } else {
                        while (validStr == false) {
                            System.out.printf("\t");
                            System.out.print("String to search: ");
                            String search = sc.nextLine();

                            if (search.length() == 0) {
                                System.out.println("Please enter a valid string to search.");
                            } else {
                                validStr = true; 
                                binarySearchAlgorithm(search, insertionSortAscending(readNames()));
                                if (binarySearchAlgorithm(search, insertionSortAscending(readNames())) == -1) {
                                    System.out.println("\tThe string " + search + " is not in the file.");
                                } else {
                                    System.out.println("\tThe string " + search + " is located at index " + binarySearchAlgorithm(search, insertionSortAscending(readNames())));
                                }
                            }
                        }
                    }
                    break;
                case "9": // Exit
                    run = false;
                    break;
                default:
                    System.out.println("Please enter a valid option from the menu.");
                    System.out.println();
                    break;
            }
        }
    }

    /**
     * Reads the names from the file.
     *
     * @return list of names
     */
    private static ArrayList<String> readNames() {
        File fileOfNames = new File("names.txt");
        ArrayList<String> names = new ArrayList<>();

        try {
            Scanner input = new Scanner(fileOfNames);
            while (input.hasNextLine()) {
                names.add(input.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(YSortSearchYourZengToni.class.getName()).log(Level.SEVERE, null, ex);
        }
        return names;
    }

    /**
     * Selection Sort to sort names in Ascending Order. Method sorts the array
     * by comparing the string at the current index with the string at the next
     * index. The array list is divided into two parts: the sublist of sorted
     * and unsorted items. The method finds the smallest element in the unsorted
     * list and places it at the end of the sorted sublist. This is continued
     * down the list until the entire list is sorted in ascending order. Going
     * from min --> max.
     *
     * @param list of unsorted names
     * @return list of sorted names
     */
    private static ArrayList<String> selectionSortAscending(ArrayList<String> list) {
        int size = list.size();
        int i = 0;
        String temp;

        while (i < size - 1) {
            int minVal = i;
            int j = i + 1;
            while (j < size) {
                if (list.get(j).compareTo(list.get(minVal)) < 0) {
                    minVal = j;
                }
                j++;
            }

            temp = list.get(minVal);
            list.set(minVal, list.get(i));
            list.set(i, temp);
            i++;
        }
        return list;
    }

    /**
     * Selection Sort to sort names in Descending Order. Method sorts the array
     * by comparing the string at the current index with the string at the next
     * index. The array list is divided into two parts: the sublist of sorted
     * and unsorted items. The method finds the largest element in the unsorted
     * list and places it at the end of the sorted sublist. This is continued
     * down the list until the entire list is sorted in descending order. max
     * --> min
     *
     * @param list of unsorted names
     * @return list of sorted names
     */
    private static ArrayList<String> selectionSortDescending(ArrayList<String> list) {
        int size = list.size();
        int i = 0;
        String temp;

        while (i < size - 1) {
            int maxVal = i;
            int j = i + 1;
            while (j < size) {
                if (list.get(j).compareTo(list.get(maxVal)) > 0) {
                    maxVal = j;
                }
                j++;
            }

            temp = list.get(maxVal);
            list.set(maxVal, list.get(i));
            list.set(i, temp);
            i++;
        }
        return list;
    }

    /**
     * Bubble Sort to sort names in Ascending Order. Method steps through the
     * list and compares adjacent pairs of elements. The elements are swapped if
     * they are in the wrong order. The pass through the unsorted portion of the
     * list is repeated until the list is sorted is ascending order. min --> max
     *
     * @param list of unsorted names
     * @return list of sorted names
     */
    private static ArrayList<String> bubbleSortAscending(ArrayList<String> list) {
        int size = list.size();
        boolean sorted = false;
        String temp;

        while (sorted == false) {
            sorted = true;
            for (int d = 0; d < size - 1; d++) {
                if (list.get(d).compareTo(list.get(d + 1)) > 0) {
                    sorted = false;
                    
                    temp = list.get(d);
                    list.set(d, list.get(d + 1));
                    list.set(d + 1, temp);
                }
            }
        }
        return list;
    }

    /**
     * Bubble Sort to sort names in Descending Order. Method steps through the
     * list and compares adjacent pairs of elements. The elements are swapped if
     * they are in the wrong order. The pass through the unsorted portion of the
     * list is repeated until the list is sorted is descending order. max -->
     * min
     *
     * @param list of unsorted names
     * @return list of sorted names
     */
    private static ArrayList<String> bubbleSortDescending(ArrayList<String> list) {
        int size = list.size();
        boolean sorted = false;
        String temp;

        while (sorted == false) {
            sorted = true;
            for (int d = 0; d < size - 1; d++) {
                if (list.get(d).compareTo(list.get(d + 1)) < 0) {
                    sorted = false;
                    
                    temp = list.get(d);
                    list.set(d, list.get(d + 1));
                    list.set(d + 1, temp);
                }
            }
        }
        return list;
    }

    /**
     * Insertion Sort to sort names in Ascending Order. On each loop iteration,
     * the method removes one element from the array, and finds the location of
     * where the element belongs within the new sorted array and inserts it
     * there. The process is repeated until no input elements remain, resulting
     * in a list sorted in ascending order.
     *
     * @param list of unsorted names
     * @return list of sorted names
     */
    private static ArrayList<String> insertionSortAscending(ArrayList<String> list) {
        int pos = 1;
        int size = list.size();

        while (pos < size) {
            int pos2 = pos;
            while (pos2 > 0 && list.get(pos2 - 1).compareTo(list.get(pos2)) > 0) {

                String temp = list.get(pos2);
                list.set(pos2, list.get(pos2 - 1));
                list.set(pos2 - 1, temp);
                pos2--;
            }
            pos++;
        }
        return list;
    }

    /**
     * Insertion Sort to sort names in Descending Order. On each loop iteration,
     * the method removes one element from the array, and finds the location of
     * where the element belongs within the new sorted array and inserts it
     * there. The process is repeated until no input elements remain, resulting
     * in a list sorted in descending order.
     *
     * @param list of unsorted names
     * @return list of sorted names
     */
    private static ArrayList<String> insertionSortDescending(ArrayList<String> list) {
        int pos = 1;
        int size = list.size();

        while (pos < size) {
            int pos2 = pos;
            while (pos2 > 0 && list.get(pos2 - 1).compareTo(list.get(pos2)) < 0) {
                
                String temp = list.get(pos2);
                list.set(pos2, list.get(pos2 - 1));
                list.set(pos2 - 1, temp);
                pos2--;
            }
            pos++;
        }
        return list;
    }

    /**
     * Binary Search. Method that searches the list of names. 
     * @param search name
     * @param list of names
     * @return -1 if name is not found, index of the given name if found (mid) 
     */
    public static int binarySearchAlgorithm(String search, ArrayList<String> list) {
        int low = 0;
        int high = list.size();
        int mid = 0;

        while (low < high) {
            mid = (low + high) / 2;
            if (list.get(mid).compareTo(search) == 0) {
                return mid;
            } else if (list.get(mid).compareTo(search) > 0) {
                high = mid - 1;
            } else if (list.get(mid).compareTo(search) < 0) {
                low = mid + 1;
            }
        }
        return -1; 
    }

    /**
     * Displays the sorted list.
     * @param sortedList 
     */
    private static void printArrayList(ArrayList<String> sortedList) {
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
        }
    }
}
