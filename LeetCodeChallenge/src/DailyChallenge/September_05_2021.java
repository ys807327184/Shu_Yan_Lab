package DailyChallenge;
/*
Date: 05 September 2021
Challenge: Sum of Distances in Tree
	There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
	You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
	Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.
	Example 1:
		Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
		Output: [8,12,6,10,10,10]
		Explanation: The tree is shown above.
		We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
		equals 1 + 1 + 2 + 2 + 2 = 8.
		Hence, answer[0] = 8, and so on.
	Example 2:
		Input: n = 1, edges = []
		Output: [0]
	Example 3:
		Input: n = 2, edges = [[1,0]]
		Output: [1,1]
 	Constraints:
		1 <= n <= 3 * 10^4
		edges.length == n - 1
		edges[i].length == 2
		0 <= ai, bi < n
		ai != bi
		The given input represents a valid tree.
Developed by: Shu Yan
 */
import java.util.*;
public class September_05_2021 {
	public int[] sumOfDistancesInTree(int n, int[][] edges) {
		int[] levels = new int[n];
        int[] result = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
        	if (map.containsKey(edges[i][0]) && !map.containsKey(edges[i][1])) {
        		map.put(edges[i][1], map.get(edges[i][0] + 1));
        	} else if (!map.containsKey(edges[i][0]) && map.containsKey(edges[i][1])) {
        		map.put(edges[i][0], map.get(edges[i][1] - 1));
        	} else {
        		map.put(edges[i][0], 1);
        		map.put(edges[i][1], 2);
        	}
        }
        return result;
    }
}
