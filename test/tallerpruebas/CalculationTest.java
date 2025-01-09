package tallerpruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CalculationTest {

	@Test
	public void testFindMaxPositiveNumbers() {
		int[] arr = {1,3,4,2};
		int expected = 4;
		int actual = Calculation.findMax(arr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindMaxNegativeNumbers() {
		int[] arr = {-1,-3,-4,-5};
		int expected = -1;
		int actual = Calculation.findMax(arr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindMaxMixedNumbers() {
		int arr[] = {-1,0,3,-2};
		int expected = 3;
		int actual = Calculation.findMax(arr);
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testFindMaxWithANumber(){
		int arr[] = {2};
		int expected = 2;
		int actual = Calculation.findMax(arr);
		assertEquals(expected, actual);
	}

}

