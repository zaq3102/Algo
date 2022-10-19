package com.ssafy.hw04;

public class ArrayMoving {
 
    public static void main(String[] args) {
    	ArrayMoving av = new ArrayMoving();
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
                
        };
        System.out.println("Original Matrix");
        av.printArr(arr);
        
        for (int i = 1; i <= 4; i++) {
			System.out.println();
			System.out.println(i + "th Matrix Moving");
			av.rotateMatrix(arr);// 회전
        	av.printArr(arr);
        	
		}
    	
    }
    
    /** 배열 한 칸씩 쉬프트 진행하는 메서드*/
    public void rotateMatrix(int[][] arr) {
		int r = 0;
		int c = 0;
		int start = 0;
		
		while(start < arr.length/2) {
			
			int temp = arr[r][c];
			
			for (; r+1 < arr.length-start; r++) { // 위로 올리는 작업
				arr[r][c] = arr[r+1][c];
			}
			
			for (; c+1 < arr.length-start; c++) { // 왼쪽으로 땡기는 작업
				arr[r][c] = arr[r][c+1];
			}
			
			for (; 0 + start <= r-1; r--) { // 위에 있는걸 내리는 작업
				arr[r][c] = arr[r-1][c];
			}
			for (; 0 + start <= c-1; c--) { // 오른쪽으로 미는 작업
				arr[r][c] = arr[r][c-1];
			}
			
			arr[r][++c] = temp;
			r++;
			start++;
		} // end of while
	} //end of rotateMatrix


	/** 배열의 원소를 출력하는 메서드*/
    public void printArr(int[][] arr) {
    	for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

    }
}

