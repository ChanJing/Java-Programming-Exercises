/*
 * Clockwise rotate a N * N square 90 degrees.
 * Performance: O(N * N)
 */

public void rotate(int[][] matrix, int n){
	for(int layer = 0; layer < n / 2; layer++){
		int first = layer;
		int last = n - 1 - layer;
		for(int i = first; i < last; i++){
			int offest = i - first;
			// Store the element form top side
			int top = matrix[first][i];

			// Copy the left element to top
			matrix[first][i] = matrix[last - offest][first];

			// Copy the down element to left
			matrix[last - offest][first] = matrix[last][last - offest]

			// Copy the right element to down
			matrix[last][last - offest] = matrix[i][last];

			// Copy the top element to right
			matrix[i][last] = top;
		}
	}
}