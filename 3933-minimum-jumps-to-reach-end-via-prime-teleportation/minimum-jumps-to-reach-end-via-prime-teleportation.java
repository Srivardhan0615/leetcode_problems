class Solution {

    // Function to check whether a number is prime
    boolean isPrime(int n) {

        // Numbers less than 2 are not prime
        if (n < 2)
            return false;

        // Check divisibility from 2 to sqrt(n)
        for (int i = 2; i * i <= n; i++) {

            // If divisible, not prime
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public int minJumps(int[] nums) {

        int n = nums.length;

        // Special case:
        // already at destination
        if (n == 1)
            return 0;

        // Map:
        // divisor -> list of indices divisible by divisor
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Build the map
        for (int i = 0; i < n; i++) {

            int val = nums[i];

            // Find all divisors of nums[i]
            for (int d = 1; d * d <= val; d++) {

                if (val % d == 0) {

                    // d is a divisor
                    map.putIfAbsent(d, new ArrayList<>());
                    map.get(d).add(i);

                    // second divisor = val / d
                    int other = val / d;

                    // avoid duplicate when d*d == val
                    if (other != d) {
                        map.putIfAbsent(other, new ArrayList<>());
                        map.get(other).add(i);
                    }
                }
            }
        }

        // BFS queue
        Queue<Integer> q = new LinkedList<>();

        // visited array
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int jumps = 0;

        // BFS starts
        while (!q.isEmpty()) {

            int size = q.size();

            // Process one level
            for (int s = 0; s < size; s++) {

                int idx = q.poll();

                // Reached end
                if (idx == n - 1)
                    return jumps;

                // -------------------
                // Move to idx - 1
                // -------------------
                if (idx - 1 >= 0 && !visited[idx - 1]) {

                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // -------------------
                // Move to idx + 1
                // -------------------
                if (idx + 1 < n && !visited[idx + 1]) {

                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }

                // -------------------
                // Prime teleportation
                // -------------------
                int val = nums[idx];

                // Teleport only if current value is prime
                if (isPrime(val)) {

                    // Get all indices divisible by val
                    List<Integer> nextIndices = map.get(val);

                    if (nextIndices != null) {

                        for (int next : nextIndices) {

                            if (!visited[next]) {

                                visited[next] = true;
                                q.offer(next);
                            }
                        }
                    }

                    // VERY IMPORTANT
                    // remove to avoid repeated processing
                    map.remove(val);
                }
            }

            jumps++;
        }

        return -1;
    }
}