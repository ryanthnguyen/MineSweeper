public class Tile
{
    public boolean isCover;
    public boolean isMark;
    public boolean isMine;
    public int adjMines;
    
    Tile()
    {
        isCover = true;
        isMark = false;
        isMine = false;
        adjMines = 0;
    }
    public void setMine()
    {
        isMine = true;
    }
    public void setAdj(int n)
    {
        adjMines = n;
    }
    public boolean getMine()
    {
        return isMine;
    }
    public boolean getMark()
    {
        return isMark;
    }
    public boolean getCover()
    {
        return isCover;
    }
    public void uncover()
    {
        if(isMark)
        System.out.println("Cannot uncover a marked tile.");
        else if(isMine)
        {
        System.out.println("Boom");
        isCover=false;
       }
        else if(isCover==false)
        System.out.println("Tile already uncovered.");
        else if(isCover)
        {
        isCover=false;
        System.out.println("Tile uncovered.");
       }
    }
    public void mark()
    {
        if(isMark)
       {
        isMark = false;
        System.out.println("Tile unmarked");
       }
        else if(isCover)
       {
        isMark = true;
        System.out.println("Tile marked");
       }
    }
    public String toString()
    {
        if(isMark==true)
        return " M |";
        else if(isCover==true)
        return "  | ";
        else if(isMine)
        return " * |";
        else if (isCover==false)
        return (" " + String.valueOf(adjMines)+" |");
        else 
        return " ? |";
    }
}
        