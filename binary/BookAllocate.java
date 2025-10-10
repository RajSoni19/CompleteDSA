package binary;

import java.util.*;

public class BookAllocate {

    // Helper function to count how many students are needed if each student gets at most 'pages' pages
    public static int countStudent(ArrayList<Integer> arr, int pages) {
        int students = 1; // Start with one student
        int pagestudent = 0; // Pages assigned to current student
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            // If adding this book doesn't exceed the limit, assign to current student
            if (pagestudent + arr.get(i) <= pages) {
                pagestudent += arr.get(i);
            } else {
                // Otherwise, assign to next student
                students++;
                pagestudent = arr.get(i);
            }
        }
        return students; // Return total students needed
    }

    // Function to find the minimum number of pages to allocate so that no student gets more than this
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n) return -1; // If students are more than books, not possible
        int low = Collections.max(arr); // Minimum possible pages (largest single book)
        int high = arr.stream().mapToInt(Integer::intValue).sum(); // Maximum possible pages (all books to one student)
        while (low <= high) {
            int mid = (low + high) / 2; // Try for the middle value
            int students = countStudent(arr, mid); // Count students needed for this mid value
            if (students > m) {
                low = mid + 1; // Too many students needed, increase pages per student
            } else {
                high = mid - 1; // Try to minimize further
            }
        }
        return low; // Minimum pages required so that no student gets more than this
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24)); // Book pages
        int n = 5; // Number of books
        int m = 4; // Number of students
        System.out.println(findPages(arr, n, m)); // Output the result
    }
}