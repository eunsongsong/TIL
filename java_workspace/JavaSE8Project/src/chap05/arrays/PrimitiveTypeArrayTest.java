package chap05.arrays;

public class PrimitiveTypeArrayTest {

	public static void main(String[] args) {
		// 1. int type Array 선언
		int[] nums;
		int nums2[];

		// 2. int type Array 초기화
		nums = new int[3];

		// 선언과 초기화를 동시에
		int[] myArr = new int[3];

		// nums 변수는 Reference type
		System.out.println(nums);

		nums[0] = 100;
		nums[1] = 200;
		nums[2] = 300;

		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);

		// 기존의 for loop 사용
		int val = 0;
		for (int i = 0; i < nums.length; i++) {
			val = nums[i];
			System.out.println(val);
		}
		
		// enhanced for loop
		for (int value : nums) {
			System.out.println(value);
		}
	}

}
