package com.lucianpiros.algorithms.problems;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class TwoSum {
	public List<Integer> twoSum(List<Integer> nums, int target) {
		List<Integer> res = new ArrayList<>();
	
		HashSet<Integer> set = new HashSet<>();

		for(Integer n : nums) {
			if(set.contains(target - n)) {
				res.add(n);
				res.add(target - n);
				break;
			}
			set.add(n);
		}
				
		return res;
	}
}
