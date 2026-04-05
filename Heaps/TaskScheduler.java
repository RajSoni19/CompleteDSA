package Heaps;

import java.util.*;

public class TaskScheduler {

    public static int leastinterval(char[] tasks, int n) {

        // store freq of each task
        Map<Character, Integer> freq = new HashMap<>();
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        // max heap create
        PriorityQueue<Integer> mh = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : freq.values()) {
            mh.add(count);
        }

        int time = 0;

        // process tasks in cycle of size(n+1)
        while (!mh.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1; // Set cycle size as cooldown + 1
            int i = 0; // Track number of tasks processed in current cycle
            while (i < cycle && !mh.isEmpty()) {
                int count = mh.poll(); // Pick the most frequent task
                count--; // Decrease frequency since task is used once

                // If task still remains, store it for next cycle
                if (count > 0) {
                    temp.add(count);
                }
                // Count 1 unit time for this task
                time++;
                i++;
            }

            // Step 4: Push remaining tasks from temp back into the heap
            for (int rem : temp) {
                mh.add(rem);
            }
            // Step 5: If heap is not empty, add idle time
            if (!mh.isEmpty()) {
                time += (cycle - i);
            }

        }

        return time;

    }

    public static void main(String[] args) {
        char task[] = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println(leastinterval(task, n));
    }
}
