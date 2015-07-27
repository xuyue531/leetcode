package com.xuyue.array.SetMatrixZeroes;

import java.util.Arrays;

import com.sun.accessibility.internal.resources.accessibility;
import com.sun.org.apache.regexp.internal.recompile;


/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * O(m+n) space
 * @author xuyue
 *
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int row_len = matrix.length;
		int col_len = (matrix != null) ? matrix[0].length : 0;
		int[] zero_row = new int[row_len];
		int[] zero_col = new int[col_len];
		for (int i = 0; i < row_len; i++) {
			for (int j = 0; j < col_len; j++) {
				if (matrix[i][j] == 0 && zero_row[i] != 1 && zero_col[j] != 1) {
					zero_row[i] = 1;
					zero_col[j] = 1;
				}
			}
		}
		for (int i = 0; i < zero_row.length; i++) {
			if (zero_row[i] == 1) {
				Arrays.fill(matrix[i], 0);
			}
		}
		for (int j = 0; j < zero_col.length; j++) {
			if (zero_col[j] == 1) {
				for (int i = 0; i < zero_row.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	/**
	 * https://leetcode.com/discuss/47405/my-c-solution-use-o-1-space-and-84ms
	 * O(1) space
	 * @param matrix
	 */
	public void setZeroes2(int[][] matrix) {
		int row_len = matrix.length;
		int col_len = matrix != null ? matrix[0].length : 0;
		int row = -1;
		int col = -1;
		if (row_len == 0 || col_len == 0) {
			return;
		}
		for (int i = 0; i < row_len; i++) {
			for (int j = 0; j < col_len; j++) {
				if (matrix[i][j] == 0) {
					row = i;
					col = j;
					break;
				}
			}
		}
		if (row == -1) {
			return;
		}
		for (int i = 0; i < row_len; i++) {
			for (int j = 0; j < col_len; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][col] = 0;
					matrix[row][j] = 0;
				}
			}
		}
		for (int i = 0; i < row_len; i++) {
			if (i == row) {
				continue;
			}
			if (matrix[i][col] == 0) {
				for (int j = 0; j < col_len; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = 0; j < col_len; j++) {
			if (j == col) {
				continue;
			}
			if (matrix[row][j] == 0) {
				for (int i = 0; i < row_len; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < row_len; i++) {
			matrix[i][col] = 0;
		}
		for (int j = 0;j < col_len; j++) {
			matrix[row][j] = 0;
		}
	}
	
	
	public static void main(String[] args) {
		SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
		int[][] input = {{1,2,3},{0,2,1},{1,2,0}};
		setMatrixZeroes.setZeroes2(input);
		System.out.println(Arrays.deepToString(input));
	}
	
}
