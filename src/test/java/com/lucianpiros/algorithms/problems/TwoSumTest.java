package com.lucianpiros.algorithms.problems;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.Before;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class TwoSumTest {
	private Random random;
	private int size;
	private TwoSum twoSum; 

	@Before
	public void initialize() {
		random = new Random();
		twoSum = new TwoSum();
	}

	@Test
	public void emptyList() {
		List<Integer> num = new ArrayList<>();
		List<Integer> result = twoSum.twoSum(num, random.nextInt(1000));
		assertTrue(result.size() == 0);
	}  

	@Test
	public void positiveTest() {
		final int MAX_VALUE = 1000;
		int runs = 1 + random.nextInt(MAX_VALUE);
		while(runs-- > 0) {
			int size = 2 + random.nextInt(MAX_VALUE);
			List<Integer> num = new ArrayList<>();
			for(int i = 0; i < size; i++) {
				num.add(1 + random.nextInt(MAX_VALUE));
			}	

			int i1 = random.nextInt(size / 2);
			int i2 = random.nextInt(size / 2) + size / 2;	
			int target = num.get(i1) + num.get(i2);

			List<Integer> result = twoSum.twoSum(num, target);
			assertTrue(result.size() == 2);
			assertTrue(result.get(0) + result.get(1) == target);
		}
	}
}
