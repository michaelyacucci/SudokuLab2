package pkgGame;

import java.util.Arrays;

import pkgHelper.LatinSquare;

import static java.lang.Math.sqrt;

public class Sudoku extends LatinSquare{
	
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
		
		iSize = puzzle.length;
		
		try {
			iSqrtSize = (int) Math.sqrt(puzzle.length);
			
		}catch(Exception e){
			throw e;
		}
		
		super.setLatinSquare(puzzle);
	}
	
	public int[][] getPuzzle(){
		return super.getLatinSquare();
		
	}
	
	public int[] getRegion(int r) {
		
		int xind = r%iSqrtSize;
		int yind = r/iSqrtSize;
		int[] region = new int[iSize];
		int row = 0;
		
		for(int i = (3*yind); i<(3*yind)+3; i++) {
			
			for(int j = (3*xind); j<(3*xind)+3; j++)
				
				region[row++] = super.getRow(i)[j];
			
		}
		
		return region;
	}
	
	/**
	 * 
	 * @param iCol
	 * @param iRow
	 * @return
	 */
	public int[] getRegion(int iCol, int iRow) {
		
		int xind = iCol/iSqrtSize;
		int yind = iRow/iSqrtSize;
		int r = 0;
		
		if(xind == 0 && yind == 0)
			r = 0;
		else if(xind == 1 && yind == 0)
			r = 1;
		else if(xind == 2 && yind == 0)
			r = 2;
		else if(xind == 0 && yind == 1)
			r = 3;
		else if(xind == 1 && yind == 1)
			r = 4;
		else if(xind == 2 && yind == 1)
			r = 5;
		else if(xind == 0 && yind == 2)
			r = 6;
		else if(xind == 1 && yind == 2)
			r = 7;
		else if(xind == 2 && yind == 2)
			r = 8;
		
		return getRegion(r);
		
	}
	
	public boolean inSudoku() {
		
		boolean isSudoku = true;
		
		if(!super.isLatinSquare())
			isSudoku = false;
		
		for(int i = 0; i < iSize; i++) {
			
			if(super.hasDuplicates(getRegion(i)))
				isSudoku = false;
			
		}
		
		if(super.ContainsZero())
			isSudoku = false;
		
		return isSudoku;
		
	}
	
	public boolean isPartialSudoku() {
		
		boolean isPartialSudoku = true;
		PartialSudoku = true;
		
		for(int i = 0; i < iSize; i++) {
			
			if(super.hasDuplicates(super.getRow(i)) 
					|| super.hasDuplicates(super.getColumn(i)) 
					|| super.hasDuplicates(getRegion(i))) {
				
				isPartialSudoku = false;
				
			}
		}
		
		PartialSudoku = false;
		return isPartialSudoku;
		
	}
	
	public boolean isValueValid(int iCol, int iRow, int iValue) {
		
		boolean isValueValid = true;
		
		for(int i = 0; i < iSize; i++) {
			
			if(super.getRow(iRow)[i]==iValue
					|| super.getColumn(iCol)[i]==iValue
					|| getRegion(iCol, iRow)[i]==iValue) {
				
				isValueValid = false;
				
			}
			
		}
		
		return isValueValid;
		
	}

}
