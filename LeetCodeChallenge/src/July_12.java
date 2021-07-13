/*
 Date: 12 July 2021
 Challenge: Find Median from Data Stream
 	The median is the middle value in an ordered integer list.
 	If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
	For example, for arr = [2,3,4], the median is 3.
	For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
	Implement the MedianFinder class:
		MedianFinder() initializes the MedianFinder object.
		void addNum(int num) adds the integer num from the data stream to the data structure.
		double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
	Example 1:
		Input
			["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
			[[], [1], [2], [], [3], []]
		Output
			[null, null, null, 1.5, null, 2.0]
		Explanation
			MedianFinder medianFinder = new MedianFinder();
			medianFinder.addNum(1);    // arr = [1]
			medianFinder.addNum(2);    // arr = [1, 2]
			medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
			medianFinder.addNum(3);    // arr[1, 2, 3]
			medianFinder.findMedian(); // return 2.0
 	Constraints:
		-10^5 <= num <= 10^5
		There will be at least one element in the data structure before calling findMedian.
		At most 5 * 10^4 calls will be made to addNum and findMedian.
 Developed by: Shu Yan
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
public class July_12 {
	/*First Version: Binary Search
	private ArrayList<Integer> arr;
	
	public July_12() {//refers to MedianFinder()
		arr = new ArrayList<Integer>();
	}
	
	public void addNum(int num) {
		int insertAt = Collections.binarySearch(arr, num);
		if (insertAt < 0) {
			insertAt = Math.abs(insertAt + 1);
			arr.add(insertAt, num);
		} else arr.add(insertAt, num);
	}
	
	public double findMedian() {
		int index = arr.size() / 2;
		double median;
		if (arr.size() % 2 > 0) {
			median = Double.valueOf(arr.get(index));
		} else {
			median = (arr.get(index) + arr.get(index - 1)) / 2.0;
		}
		return median;
	}*/
	
	//Second Version Using Priority Queue
	private PriorityQueue<Integer> pqMax;
	private PriorityQueue<Integer> pqMin;
	
	public July_12() {//refers to MedianFinder()
		pqMax = new PriorityQueue<>(Collections.reverseOrder());
		pqMin = new PriorityQueue<>();
	}
	
	public void addNum(int num) {
		if (pqMax.isEmpty() || num < pqMax.peek()) pqMax.add(num);
		else pqMin.add(num);
		
		if ((pqMax.size() - pqMin.size()) > 1) {
			pqMin.add(pqMax.peek());
			pqMax.remove();
		} else if ((pqMin.size() - pqMax.size()) > 1) {
			pqMax.add(pqMin.peek());
			pqMin.remove();
		}
	}
	
	public double findMedian() {
		double median;
		if (pqMax.size() == pqMin.size()) median = (pqMax.peek() + pqMin.peek()) / 2.0;
		else if (pqMax.size() > pqMin.size()) median = pqMax.peek();
		else median = pqMin.peek();
		return median;
	}
}
