package assignments;

public class Sudoku {
	
	public static boolean sudokuBoard(int[][] board,int n )
	{
		int row=-1;
		int col=-1;
		boolean isEmpty=true;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(board[i][j]==0)
				{
					row=i;
					col=j;
					
					isEmpty=false;
					break;
				}
			}
			
			if(!isEmpty)
			{
				break;
			}
		}
		if(isEmpty)
		{
			return true;
		}
		
		for(int num=1;num<=n;num++)
		{
			if(isSafePlace(board,row,col,num))
			{
				board[row][col]=num;
				
				if(sudokuBoard(board,n))
				{
					return true;
				}
				else
				{
					board[row][col]=0;
				}
			}
		}
		return false;
	}
	
	public static boolean isSafePlace(int[][] board,int row,int col,int num)
	{
		for(int j=0;j<board.length;j++)
		{
			if(board[row][j]==num)
			{
				return false;
			}
		}
		
		for(int i=0;i<board.length;i++)
		{
			if(board[i][col]==num)
			{
				return false;
			}
		}
		int sqrt=(int)Math.sqrt(board.length);	
		int rowStart=row-row%sqrt;
		int colStart=col-col%sqrt;
		
		for(int r=rowStart;r<rowStart+sqrt;r++)
		{
			for(int c=colStart;c<colStart+sqrt;c++)
			{
				if(board[r][c]==num)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static void printSudoku(int[][] board,int n)
	{
		for(int row=0;row<n;row++)
		{
			for(int col=0;col<n;col++)
			{
				System.out.print(board[row][col]+" ");
//				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		int[][] board= {{7,0,0,0,0,0,2,0,0},{4,0,2,0,0,0,0,0,3},{0,0,0,2,0,1,0,0,0}
		,{3,0,0,1,8,0,0,9,7},{0,0,9,0,7,0,6,0,0},{6,5,0,0,3,2,0,0,1},{0,0,0,4,0,9,0,0,0}
		,{5,0,0,0,0,0,1,0,6},{0,0,6,0,0,0,0,0,8}};
		int n=board.length;
		if(sudokuBoard(board,n))
		{
			printSudoku(board,n);
		}
		else
		{
			System.out.println("no solution");
		}
	}

}

