package coen352.ch4.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ListJUnitTest<Key> {

	  private static ADTList<Integer> L1;
	  private static ADTList<Integer> L2;
	  private static ADTList<Object> L3;
	  private static ADTList<String> freeList1;
	  private static ADTList<String> freeList2;
	  
	  
	  
	  /**
	   * This method is automatically called once before each test case method,
	   * so that all the variables are cleanly initialized for each test.
	   */
	  @BeforeAll
	  public static void setUp()
	  {
	    L1 = new DList<Integer>();
	    L2 = new AList<Integer>(15);
	    L3 = new DList<Object>();
	    freeList1 = new FreeLList<String>();
	    freeList2 = new FreeLList<String>();
	  }
	
	  /** @return True if k is in list L, false otherwise */
	  public static boolean find(ADTList<Integer> L, int k) {
		  
		  int currPos = L.currPos(); 
		  for (L.moveToStart(); L.currPos()<L.length(); L.next())
		    if (k == L.getValue()) {
		    	L.moveToPos(currPos);
		    	return true;    // Found k
		    }
		    	
		  L.moveToPos(currPos);
		  return false;    // k not found
	  }
	  
	  public static int findByKey(ADTList<Integer> L, int key) {
				
				int currPos = L.currPos(); 
				int index = 0;
				for (L.moveToStart(); L.currPos()<L.length(); L.next(),index++) {
				    if (key == L.getValue()) {
				    	
				    	L.moveToPos(currPos);
				    	return index;
				    	
				    }
				    	
				    
				}   	
				L.moveToPos(currPos);
				return -1; 
	}
	  
	  
	 
	 @Test
	  public void testRemove()
	  {
		L2.clear(); 
	    L2.append(1);
	    assertEquals("< | 1 >", L2.toString());
	    assertEquals(1, (int)L2.remove());
	    assertEquals("< | >", L2.toString());
	    assertEquals(null, L2.remove());
	  }
	 
	 @Test
	  public void testAppend()
	  {
		L2.clear(); 
		L2.append(10);
	    assertEquals("< | 10 >", L2.toString());
	    L2.append(20);
	    L2.append(15);
	    assertEquals("< | 10 20 15 >", L2.toString());
	  }

	 @Test
	  public void testFind()
	 {
	    
		L1.clear(); 
		L1.moveToStart();
	    L1.insert(39);
	    L1.insert(9);
	    L1.insert(5);
	    L1.append(4);
	    L1.append(3);
	    L1.append(2);
	    L1.append(1);
	   
	    assertEquals("< | 5 9 39 4 3 2 1 >", L1.toString());
	    assertEquals(7, L1.length());

	    assertEquals(true, find(L1, 3));
	    assertEquals(false, find(L1, 29));
	    assertEquals(true, find(L1, 5));
	   
	    
	    assertEquals(0,findByKey(L1,5));
	    assertEquals(1,findByKey(L1, 9));
	    assertEquals(2,findByKey(L1, 39));
	    assertEquals(3,findByKey(L1,4));
	    assertEquals(4,findByKey(L1,3));
	    assertEquals(5,findByKey(L1,2));
	    assertEquals(6,findByKey(L1,1));
	    assertEquals(-1,findByKey(L1,40));
	   
	    L1.moveToPos(1);
	    L1.setValue(41);
	    assertEquals(1, L1.findByKey(41)); //using ADTList definition of findByKey per implementation
	    assertEquals(true,find(L1,41)); //using algorithm definition cross all the implementation
	   
	    
	  }

	 @Test
	  public void testListOfObjects()
	  {
	    assertEquals("< | >", L3.toString());
	    L3.insert(3);
	    assertEquals("< | 3 >", L3.toString());
	    L3.insert("Hello");
	    assertEquals("< | Hello 3 >", L3.toString());
	  }

	 @Test
	  public void testNext() {
	    L2.append(10);
	    L2.append(20);
	    L2.append(15);
	    L2.moveToStart();
	    L2.next();
	    assertEquals(20, (int)L2.getValue());
	  }

	 @Test
	  public void testMore() {
	    L2.clear();
	    L2.moveToStart();
	    L2.insert(1);
	    L2.insert(2);
	    L2.moveToPos(2);
	    L2.insert(3);
	    L2.clear();
	    assertEquals("< | >", L2.toString());
	  }
	 
	 @Test
	 public void testFreeList() {
		 freeList1.insert("s1");
		 freeList1.remove();
		 freeList2.insert("s2");
		 
		 
	 }

}
