/*
 * There is a M * N Matrix. If the value of element is 0,
 * set the elements which are in same column and row are 0 too.
 * IMPORTANT: If check and reset the value at the same time, 
 * all the elements would be 0. Therefore, using two arrays store
 * the number of column and row which contain zero elements.
 */

public void setZeros(int[][] matrix){
	boolean[] row = new boolean[matrix.length];
	boolean[] column = new boolean[matrix[0].length];

	// Store the number of column and row which contain zero elements.
	for(int i = 0; i < matrix.length; i++){
		for(int j = 0; j < matrix[0].length; j++){
			row[i] = true;
			column[j] = true;
		}
	}

	// If there is a zero element in row i or column j, set arr[i][j] is 0
	for(int i = 0; i < matrix.length; i++){
		for(int j = 0; j < matrix[0].length; j++){
			if(row[i] || column[j]){
				matrix[i][j] = 0;
			}
		}
	}
}