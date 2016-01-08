import java.util.Iterator;

//Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- 
//it essentially peek() at the element that will be returned by the next call to next().
//Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
//Call next() gets you 1, the first element in the list.
//Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
//You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
		
public class PeekingIterator implements Iterator<Integer> {
	
	private Iterator<Integer> iterator;
	private Integer integer=null;
	
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator=iterator;
	    if(iterator.hasNext())
	    	integer=iterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return integer;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer res=integer;
	    integer=iterator.hasNext()? iterator.next() : null;
	    return res;
	}

	@Override
	public boolean hasNext() {
	    return integer!=null;
	}
}
