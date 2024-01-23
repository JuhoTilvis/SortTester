package SortHarjoitus;
import java.util.Random;
import java.util.Scanner;
import java.io.Console;
import java.util.Arrays;


public class selectionSortExample {
 
 
    public static int[] createAscendingTable(int[] array) 
    {
        //int[] array = new int[n];
        for (int i = 0; i < array.length; i++) 
        {
            array[i] = i;
        }
        return array;
    }
 
    public static int[] createDescendingTable(int[] array) 
    {
        //int[] array = new int[n];
        for (int i = 0; i < array.length; i++) 
        {
            array[i] = array.length-i;
        }
        return array;
    }
 
    public static int[] makeRandomArray(int n)
    {
        int[] array = new int[n];
        Random gen = new Random();
        for (int i = 0; i < array.length; i++) 
        {
            array[i] = gen.nextInt(n);
        }
        return array;
    }
 
    public static void printArray(int[] array)
    {
        for (int i : array) 
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
 
    public static void insertionSort(int[] arr) 
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) 
        {
            int key = arr[i];
            int j = i - 1;
 
            while (j >= 0 && arr[j] > key) 
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
 
    public static void selectionSort(int[] arr) 
    {
        int n = arr.length;
 
        for (int i = 0; i < n - 1; i++) 
        {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
 
    }
 
    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    static int partition(int[] arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr[high];
        int temp;
 
        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) 
        {
 
            // If current element is smaller than the pivot
            if (arr[j] < pivot) 
            {
 
                // Increment index of smaller element
                i++;
                //swap(arr, i, j);
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swap(arr, i + 1, high);
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
 
        return (i + 1);
    }
 
        // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    public static void quickSort(int[] arr, int low, int high) 
    {
    if (low < high) 
    {
        // pi is partitioning index, arr[p] is now at right place
        int pi = partition(arr, low, high);

        // Separately sort elements before partition and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
    else {
        // Palaa, jos low on suurempi tai yhtä suuri kuin high
        return;
    }
    }
 
    public static void quickSortTest(int[] arr)
    {
        quickSort(arr, 0, arr.length - 1);
    }
   
 
 
    public static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
   
        for (i = 0; i < n - 1; i++) 
        {
            swapped = false;
   
            for (j = 0; j < n - i - 1; j++) 
            {
                if (arr[j] > arr[j + 1]) 
                {
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
   
            // If no two elements were swapped by inner loop, then break
            if (!swapped) 
            {
                break;
            }
        }
    }
    public static void bubbleSortTest(int[] arr)
    {
        bubbleSort(arr, 0);
    }
    public static void arraySort(int[] arr, int n) 
    {
        Arrays.sort(arr);
    }
    public static void arraySortTest(int[] arr) 
    {
        arraySort(arr,0);    
    }
    public static void shellSort(int[] arr, int n) 
    {
        for (int gap = n/2; gap > 0; gap /= 2) 
        { 

            for (int i = gap; i < n; i += 1) 
            { 
                int temp = arr[i]; 

                int j; 
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
                    arr[j] = arr[j - gap]; 
                arr[j] = temp; 
            } 
        }
    }
    public static void shellSortTest(int[] arr) 
    {
        shellSort(arr, 0);    
    }
    private interface FunctionPointer 
    {
        // Method signatures of pointed method
        void methodSignature(int[] arr);
    }
    public static void SortMethodTester(FunctionPointer methodToBeTested, String methodName, int n, int taulukko)
    {
        // Tehdään satunnainen taulukko.
        int[] array = makeRandomArray(n);

        if (taulukko == 1)
            {
                int[] arrayNouseva= createAscendingTable(array);
                long start = System.nanoTime();
                // Kutsutaan parametrina annettua testattavaa metodia.
                methodToBeTested.methodSignature(arrayNouseva);
                long end = System.nanoTime();
                long kesto = end - start;
                System.out.println(methodName + " nousevalla taulukolla: " + kesto + " nanosekunttia");
                  
            }
            if (taulukko==2)
            {
                int[] arrayLaskeva= createDescendingTable(array);
                long start = System.nanoTime();
                methodToBeTested.methodSignature(arrayLaskeva);
                long end = System.nanoTime();
                long kesto = end - start;
                System.out.println(methodName + " laskevalla taulukolla: " + kesto + " nanosekunttia");
            }
            if (taulukko != 1 && taulukko != 2)
            {
                long start = System.nanoTime();
                methodToBeTested.methodSignature(array);
                long end = System.nanoTime();
                long kesto = end - start;
                System.out.println(methodName + " arvotulla taulukolla: " + kesto + " nanosekunttia"); 
            }
    }
       
 
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Kerro millaisen taulun haluat arviontiin (1= Nouseva-, 2= laskevataulukko, joku muu kuin edelliset= arvottu järjestys): ");        
            int taulukko = scanner.nextInt();
            // nämä voisivat olla taulukossa
            FunctionPointer methodi1 = selectionSortExample::insertionSort;
            FunctionPointer methodi2 = selectionSortExample::selectionSort;
            FunctionPointer methodi3 = selectionSortExample::quickSortTest;
            FunctionPointer methodi4= selectionSortExample::bubbleSortTest;
            FunctionPointer methodi5= selectionSortExample::arraySortTest;
            FunctionPointer methodi6= selectionSortExample::shellSortTest;
            FunctionPointer methodi7 = MergeSortExample::mergeSortTest;


 
            /// ja näitä voisi kutsua silmukassa
            SortMethodTester(methodi1, "InsertionSort", 10000, taulukko);
            SortMethodTester(methodi2, "SelectionSort", 10000, taulukko);
            SortMethodTester(methodi3, "QuickSort", 10000, taulukko);
            SortMethodTester(methodi4, "BubbleSort", 10000, taulukko);
            SortMethodTester(methodi5, "Arraysort", 10000, taulukko);
            SortMethodTester(methodi6, "Shellsort",10000, taulukko);;
            SortMethodTester(methodi7, "Mergesort", 10000, taulukko);
 
        }
    }