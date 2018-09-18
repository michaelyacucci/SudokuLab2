package pkgGame;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class Sudoku {
	
	private int iSize;
	private int iSqrtSize;
	
	public Sudoku(int size) {
		
		iSize = size;
		
		try {
			iSqrtSize = (int) Math.sqrt(size);
			
		}catch(Exception e){
			throw e;
		}
		
	}
	
	public Sudoku(int[][] puzzle) {
		
	}
	
	public int[][] getPuzzle(){
		
		return null;
		
	}
	
	public int[] getRegion(int r) {
		
		return null;
		
	}
	
	public int[] getRegion(int iCol, int iRow) {
		
		return null;
		
	}
	
	public boolean inSudoku() {
		
		return false;
		
	}
	
	public boolean isPartialSudoku() {
		
		return false;
		
	}
	
	public boolean isValueValid(int iCol, int iRow, int iValue) {
		
		return false;
		
	}

}
