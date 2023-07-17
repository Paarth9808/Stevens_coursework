//Paarth Badola
//20012789

public class MatrixMultiplication {
	public int[][] partition(int [][]A, int a, int b){
		int n = A.length;
		int [][]retArr = new int[n/2][n/2];
		for (int i = 0; i<n/2; i++) {
			for (int j =0; j<n/2; j++) {
				retArr[i][j] = A[i+a][j+b];
			}
		}
		return retArr;
	}
	
	public int determinant(int [][] A) {
		int n = A.length;
		
		int[][] A11 = new int[n/2][n/2];
        int[][] A12 = new int[n/2][n/2];
        int[][] A21 = new int[n/2][n/2];
        int[][] A22 = new int[n/2][n/2];
        
        A11 = partition(A, 0, 0);
        A12 = partition(A, 0, n/2);
        A21 = partition(A, n/2, 0);
        A22 = partition(A, n/2, n/2);
        
        int detA11 = (A11[0][0]*A11[1][1]) - (A11[0][1]*A11[1][0]);
        int detA12 = (A12[0][0]*A12[1][1]) - (A12[0][1]*A12[1][0]);
        int detA21 = (A21[0][0]*A21[1][1]) - (A21[0][1]*A21[1][0]);
        int detA22 = (A22[0][0]*A22[1][1]) - (A22[0][1]*A22[1][0]);
		
        int sum = detA11+detA12+detA21+detA22;
        
        return sum;
	}
	
	public int [][] add(int[][] A, int[][] B){
		int n = A.length;
		int [][]C = new int[n][n];
		for(int i=0;i<n;i++){    
			for(int j=0;j<n;j++){    
				C[i][j]=A[i][j]+B[i][j];
			}
		}
		return C;
	}
	
	public void append(int[][]a, int[][]b, int n1, int n2){
		int n = a.length;
		for(int i1 = 0, i2 = n1; i1 < n; i1++, i2++)
            for(int j1 = 0, j2 = n2; j1 < n; j1++, j2++)
                b[i2][j2] = a[i1][j1];		
	}
	
	public int[][] recursiveMatrixMultiplication(int[][] A, int[][] B){
		int n = A.length;
		int [][]C = new int[n][n];
		 
        if (n == 1)
            C[0][0] = A[0][0] * B[0][0];
        else {
        	int [][]A11 = partition(A, 0, 0);
    		int [][]A12 = partition(A, 0, n/2);
    		int [][]A21 = partition(A, n/2, 0);
    		int [][]A22 = partition(A, n/2, n/2);
    		
    		int [][]B11 = partition(B, 0, 0);
    		int [][]B12 = partition(B, 0, n/2);
    		int [][]B21 = partition(B, n/2, 0);
    		int [][]B22 = partition(B, n/2, n/2);
    		
    		int [][]C11 = partition(C, 0, 0);
    		int [][]C12 = partition(C, 0, n/2);
    		int [][]C21 = partition(C, n/2, 0);
    		int [][]C22 = partition(C, n/2, n/2);
    		
    		C11 = add(recursiveMatrixMultiplication(A11,B11), recursiveMatrixMultiplication(A12,B21));
    		C12 = add(recursiveMatrixMultiplication(A11,B12), recursiveMatrixMultiplication(A12,B22));
    		C21 = add(recursiveMatrixMultiplication(A21,B11), recursiveMatrixMultiplication(A22,B21));
    		C22 = add(recursiveMatrixMultiplication(A21,B12), recursiveMatrixMultiplication(A22,B22));
    		
    		append(C11, C, 0 , 0);
            append(C12, C, 0 , n/2);
            append(C21, C, n/2, 0);
            append(C22, C, n/2, n/2);
        }
        return C;
	}
	
	public static int[][] iterativeMatrixMultiplication(int[][] A, int[][] B) {
		
		int a_rows=A.length;
	    int a_columns=A[0].length;
	    int b_columns=B[0].length;
	    int[][] C = new int[a_rows][b_columns];
	    
		for (int i = 0; i < a_rows; i++) {
			for (int j = 0; j < b_columns; j++) {
				for (int k = 0; k < a_columns; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
	    return C;
	}
	
	public boolean equalMatrix(int[][] A, int[][] B) {
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[i][j] != B[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		MatrixMultiplication mm = new MatrixMultiplication();
		int [][]a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {-8, -7, -6, -5}, {-4, -3 ,-2 ,-1}};
		int [][]b = {{10, 11, 14, 15}, {12, 13, 16, 17}, {-18, -17, -16, -15}, {-14, -13 ,-12 ,-11}};
		
		System.out.println(mm.determinant(a));
		System.out.println(mm.determinant(b));
		
		int [][]e = mm.recursiveMatrixMultiplication(a, b);
		int [][]f = mm.iterativeMatrixMultiplication(a, b);
		
		System.out.println(mm.equalMatrix(e,f));
	}
}
