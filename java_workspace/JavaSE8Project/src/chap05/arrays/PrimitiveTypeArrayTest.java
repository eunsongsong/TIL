package chap05.arrays;

public class PrimitiveTypeArrayTest {

	public static void main(String[] args) {
		// 1. int type Array ����
		int[] nums;
		int nums2[];

		// 2. int type Array �ʱ�ȭ
		nums = new int[3];

		// ����� �ʱ�ȭ�� ���ÿ�
		int[] myArr = new int[3];

		// nums ������ Reference type
		System.out.println(nums);

		nums[0] = 100;
		nums[1] = 200;
		nums[2] = 300;

		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);

		// ������ for loop ���
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
