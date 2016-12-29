import java.io.*;
import java.util.Random;
public class Life5 {
private boolean[][] cells;
public static void main( String[] args ) {
  Life generation = new Life( );
  for (int i = 0; i != 10; i++) {
    System.out.println( generation );
    generation.next( );
  }
}
// Constructors
public void next (){

  int SIZE;
  SIZE=cells.length;
  boolean[][] tempCells = new boolean [SIZE] [SIZE]; 

  for( int i=0; i<SIZE; i++ ) {
 for( int j=0; j<SIZE; j++ ) {
  tempCells[i][j] = cells[i][j];
 }
  } 
  for (int row = 0; row < cells.length ; row++)
  {
    for (int col = 0 ; col < cells[row].length ; col++)
    {
      if ( neighbours(row, col) > 3  ||  neighbours(row, col) < 2 )
      {
        tempCells[row][col] = false;
      }
      else if (neighbours(row, col) == 3 )
      {
        tempCells[row][col] = true;
      }      
    }
  }
  cells = tempCells;
}
public int neighbours (int row, int col) {
  int acc=0;
  for ( int i = row -1; i <= row + 1 ; i++)
    {
     for (int j = col -1 ; j <= col + 1 ; j++)
       {
       try {
         if (cells[i][j]==true && (i != row || j!=col))
         {
           acc++;
         }          
       } catch ( ArrayIndexOutOfBoundsException f)
       {continue;}
     }
  }
  return acc;
}
// Initialises 6 * 6 grid with Glider pattern.
public Life( ) {
final int SIZE = 8;
// this should have been a class (static) array.
final int[][] pairs = {{2,4},{3,3},{1,2},{2,2},{3,2}};
cells = new boolean[ SIZE ][ ];
for (int row = 0; row < SIZE; row ++) {
cells[ row ] = new boolean[ SIZE ];
}
for (int pair = 0; pair < pairs.length; pair ++) {
final int row = pairs[ pair ][ 0 ];
final int col = pairs[ pair ][ 1 ];
cells[ row ][ col ] = true;
}
}
 // Initialise size * size grid with random cells.
// Public methods and helper methods.
@Override
public String toString( ) {
String result = "";
for (int row = 0; row < cells.length; row ++) {
final boolean[] column = cells[ row ];
for (int col = 0; col < column.length; col ++) {
result = result + (column[ col ] ? "x" : ".");
}
result = result + "\n";
}
return result;
}
}