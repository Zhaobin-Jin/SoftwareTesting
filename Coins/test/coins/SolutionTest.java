package coins;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	public Solution sol;
	@Test
	public void test() {
		sol = new Solution();
		
		int input1=104;
		int input2=40;
		int input3=23;
		int input4=66;
		int input5=9;
		
		assertTrue(!sol.dividable(input1));
		assertTrue(sol.dividable(input2));
		assertTrue(sol.dividable(input3));
		assertTrue(sol.dividable(input4));
		assertTrue(!sol.dividable(input5));
		
	}

}
