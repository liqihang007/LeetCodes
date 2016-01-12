//Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
//So the median is the mean of the two middle value.
//Examples: 
//[2,3,4] , the median is 3
//[2,3], the median is (2 + 3) / 2 = 2.5
//Design a data structure that supports the following two operations:
//void addNum(int num) - Add a integer number from the data stream to the data structure.
//double findMedian() - Return the median of all elements so far.
//For example:
//add(1)
//add(2)
//findMedian() -> 1.5
//add(3) 
//findMedian() -> 2

import java.util.*;

public class FindMedianfromDataStream {
	
	private PriorityQueue<Integer>leftMax = new PriorityQueue<Integer>(Collections.reverseOrder()); 
    private PriorityQueue<Integer>rightMin = new PriorityQueue<Integer>();

    // Adds a number into the data structure.
    public void addNum(int num) { 
        leftMax.offer(num);
        rightMin.offer(leftMax.poll());
        if (leftMax.size() < rightMin.size())
            leftMax.offer(rightMin.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (leftMax.size() == rightMin.size()) return (leftMax.peek() + rightMin.peek()) / 2.0;
        return leftMax.peek();
    }
    
	// Your MedianFinder object will be instantiated and called as such:
	// MedianFinder mf = new MedianFinder();
	// mf.addNum(1);
	// mf.findMedian();
}

