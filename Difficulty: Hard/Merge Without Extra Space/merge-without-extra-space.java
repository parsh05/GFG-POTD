//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        int n1 = a.length, n2 = b.length;
        int gap = (n1 + n2) / 2 + (n1 + n2) % 2; // Initial gap calculation (ceil value)

        while (gap > 0) {
            int i = 0, j = gap; // Start comparing elements with the given gap

            while (j < n1 + n2) {
                // Compare elements within a[] when both pointers are in the first array
                if (i < n1 && j < n1) {
                    swapIfGreater(a, i, a, j);
                }
                // Compare elements when i is in a[] and j is in b[]
                else if (i < n1 && j >= n1) {
                    swapIfGreater(a, i, b, j - n1);
                }
                // Compare elements within b[] when both pointers are in the second array
                else {
                    swapIfGreater(b, i - n1, b, j - n1);
                }
                i++;
                j++;
            }

            // Update gap for the next iteration
            if (gap == 1) break;
            gap = (gap / 2) + gap % 2;
        }
    }

    // Helper function to swap elements if the element in a[] is greater than the element in b[]
    private void swapIfGreater(int[] a, int i, int[] b, int j) {
        if (a[i] > b[j]) {
            int temp = a[i];
            a[i] = b[j];
            b[j] = temp;
        }
    }
}
