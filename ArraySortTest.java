import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;


public class ArraySortTest {

	private int [][] myArr;
	@Before
	public void setUp() throws Exception {
		
		     myArr = new int [100][];
		
			for(int i = 0; i < 100; i++){
				Random rand = new Random();
				int arrSize = rand.nextInt(50) + 1;
				myArr[i] = new int[arrSize];
				
				for(int j = 0; j < arrSize; j++){
				   myArr[i][j] = rand.nextInt();
				}
			}
				//Arrays.sort(myArr);
		}
		
	//Test to make sure that the arrays are actually sorted
	@Test
	public void testIsSorted() {

		boolean isNextGreater;
		
		for(int i = 0; i < 100; i++){
			Arrays.sort(myArr[i]);
			isNextGreater = false;
			for(int j = 0; j < myArr[i].length - 1; j++){
				if(myArr[i][j] < myArr[i][j+1]){
					isNextGreater = true;
				}
				assertEquals(true, isNextGreater);
			}
			
		}
	}

	//Test to make sure Array is same length before and after sorting
	@Test
	public void testSameLength() {

		int lengthBefore;
		int lengthAfter;
		for(int i = 0; i < 100; i++){
			
			lengthBefore = myArr[i].length;
			Arrays.sort(myArr[i]);
			lengthAfter = myArr[i].length;
			
			assertEquals(lengthBefore, lengthAfter);
			
		}
	}
	
	//Test to make sure every integer in pre-sorted array is in post-sorted array
	@Test
	public void testNotMissingAny() {

		int [][] oldArray = new int [100][];
		
		//copying the arrays into oldArray
		for(int i = 0; i < 100; i++){
			
			oldArray[i] = new int[myArr[i].length];
			
			for(int j = 0; j < myArr[i].length; j++){
				oldArray[i][j] = myArr[i][j];
			}
		}
		
		//asserting that each integer in each pre-sorted array is in the sorted array
		for(int i = 0; i < 100; i++){

			Arrays.sort(myArr[i]);
			boolean found = false;
			
			for(int j = 0; j < oldArray[i].length; j++){
				found = false;
				for(int k = 0; k < myArr[i].length; k++){
					if(myArr[i][k] == oldArray[i][j]){
						found = true;
						break;
					}
					
				}
				assertEquals(true, found);
			}
			
			
		}
	}
}
