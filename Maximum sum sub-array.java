class MaximumSum
{
	// Naive solution to find Maximum sum subarray using
	// divide and conquer
	public static int MaximumSum(int[] A)
	{
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;

		// do for each subarray starting with i
		for (int i = 0; i < A.length - 1; i++)
		{
			// calculate sum of subarray A[i..j]

			sum = 0;	// reset sum

			// do for each subarray ending with j
			for (int j = i; j < A.length; j++)
			{
				sum += A[j];

				// if current subarray sum is greater than the maximum
				// sum calculated so far, update the maximum sum
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}

		return maxSum;
	}

	public static void main(String[] args)
	{
		int[] A = { 2, -4, 1, 9, -6, 7, -3 };
		System.out.println("The Maximum sum of the subarray is "
							+ MaximumSum(A));
	}
}
