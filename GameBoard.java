import java.util.*;
public class GameBoard
{
    public Tile[][] board;
    
    GameBoard()
    {
        board = new Tile[1][1];
    }
    public boolean bgetCover(int x, int y)
    {
        return board[x][y].getCover();
    }
    public void bmark(int x, int y)
    {
        board[x][y].mark();
    }
    public void buncover(int x, int y)
    {
        board[x][y].uncover();
    }
    public boolean bgetMine(int x, int y)
    {
        return board[x][y].getMine();
    }
    GameBoard(int x, int y, int mines)
    {
        board = new Tile[x][y];
        initialize1(x,y);
        placeMines(mines);
        initialize2();
    }
    public void placeMines(int mines)
    {
        int xCo;
        int yCo;
        for(int i = 0; i<mines;)
        {
            xCo=(int)(Math.random()*board.length);
            yCo=(int)(Math.random()*board[0].length);
            if(board[xCo][yCo].getMine()==false)
            {
                board[xCo][yCo].setMine();
                i++;
                //System.out.println("Mine set");
            }
        }
    }
    public void initialize1(int x, int y)
    {
        //Need to initialize each tile object
        int k = 0;
        for(int i = 0; i < x; i++)
        {
            for(int j = 0; j<y; j++)
            {
                board[i][j]= new Tile();
            }
        }
        
        
    }
    public void initialize2()
    {
       //Passing each tile to checkAdjacent
       for(int i = 0; i<board.length;i++)
       {
           for(int j = 0; j<board[0].length;j++)
           {
               checkAdj(board[i][j],i,j);
           }
       }
    }
    public void checkAdj(Tile n, int xCo, int yCo)
    {
        int adj = 0;
        if(board[xCo][yCo].getMine())
        {
            board[xCo][yCo].setAdj(-1);
            return;
        }
            if(xCo-1>=0&yCo-1>=0)
        {
            if(board[xCo-1][yCo-1].getMine())
            {
                adj++;
            }
        }
        if(xCo-1>=0&yCo>=0)
        {
            if(board[xCo-1][yCo].getMine())
            {
                adj++;
            }
        }
        if(xCo-1>=0&yCo+1<board[0].length)
        {
            if(board[xCo-1][yCo+1].getMine())
            {
                adj++;
            }
        }
        if(xCo>0&yCo-1>0)
        {
            if(board[xCo][yCo-1].getMine())
            {
                adj++;
            }
        }
        if(xCo>=0&yCo+1<board[0].length)
        {
            if(board[xCo][yCo+1].getMine())
            {
                adj++;
            }
        }
        if(xCo+1<board.length&yCo-1>=0)
        {
            if(board[xCo+1][yCo-1].getMine())
            {
                adj++;
            }
        }
        if(xCo+1<board.length&yCo<board[0].length)
        {
            if(board[xCo+1][yCo].getMine())
            {
                adj++;
            }
        }
        if(xCo+1<board.length&yCo+1<board.length)
        {
            if(board[xCo+1][yCo+1].getMine())
            {
                adj++;
            }
        }
        //System.out.println("x: " + xCo + "y: " + yCo + " adj: " + adj);
        board[xCo][yCo].setAdj(adj);
    }
    
    public String toString()
    {
        System.out.print("   ");
        for(int i = 0; i<board.length; i++)
        {
            System.out.print(" " + i+ "  ");
        }
        
        for(int i = 0; i<board.length; i++)
        {
          System.out.println("         ");
          System.out.print("  ");
            for(int k = 0; k<board.length;k++)
          {
              System.out.print("+---");
          }
            System.out.print("+");
            System.out.print("\n" +i + " | ");
            for(int j = 0; j<board[0].length; j++)
            {
                System.out.print(board[i][j]);
            }
        }
        System.out.println(" ");   
        System.out.print("  ");
        for(int k = 0; k<board.length;k++)
          {
              System.out.print("+---");
          }
        System.out.print("+");
          return "";
    }
}

    