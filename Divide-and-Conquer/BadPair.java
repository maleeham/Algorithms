Problem 4. Let A[::] be an array of n distinct numbers. We call a pair (A[i];A[j]) bad, if i < j and A[i] >
A[j]+10. Design a divide-and-conquer algorithm that computes the number of bad pairs in A in O(n lg n) time.
  
class Algo { 
  
    /* This method sorts the input array and returns the 
       number of inversions in the array */
    static int mergeSort(int arr[], int array_size) 
    { 
        int temp[] = new int[array_size]; 
        return _mergeSort(arr, temp, 0, array_size - 1); 
    } 
  
    /* An auxiliary recursive method that sorts the input array and 
      returns the number of inversions in the array. */
    static int _mergeSort(int arr[], int temp[], int left, int right) 
    { 
        int mid, inv_count = 0; 
        if (right > left) { 
            /* Divide the array into two parts and call _mergeSortAndCountInv() 
           for each of the parts */
            mid = (right + left) / 2; 
  
            /* Inversion count will be sum of inversions in left-part, right-part 
          and number of inversions in merging */
            inv_count = _mergeSort(arr, temp, left, mid); 
            inv_count += _mergeSort(arr, temp, mid + 1, right); 
  
            /*Merge the two parts*/
            inv_count += merge(arr, temp, left, mid + 1, right); 
        } 
        return inv_count; 
    } 
  
    /* This method merges two sorted arrays and returns inversion count in 
       the arrays.*/
    static int merge(int arr[], int temp[], int left, int mid, int right) 
    { 
        int i, j, k; 
        int inv_count = 0; 
  
        i = left; /* i is index for left subarray*/
        j = mid; /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right)) { 
            if (arr[i] <= arr[j]+10) { 
                temp[k++] = arr[i++]; 
            } 
            else { 
                temp[k++] = arr[j++]; 
  
                inv_count = inv_count + (mid - i); 
            } 
        } 
  
        /* Copy the remaining elements of left subarray 
       (if there are any) to temp*/
        while (i <= mid - 1) 
            temp[k++] = arr[i++]; 
  
        /* Copy the remaining elements of right subarray 
       (if there are any) to temp*/
        while (j <= right) 
            temp[k++] = arr[j++]; 
  
        /*Copy back the merged elements to original array*/
        for (i = left; i <= right; i++) 
            arr[i] = temp[i]; 
  
        return inv_count; 
    } 
  
    
}
