import java.util.*;
public class GameClient
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of columns.");
        int xCo = input.nextInt();
        System.out.println("Enter number of rows.");
        int yCo = input.nextInt();
        System.out.println("Enter number of mines.");
        int mines = input.nextInt();
        GameBoard test = new GameBoard(xCo,yCo,mines);

        

        //String action = new String();
        int action = -1;
        int x = -1;
        int y = -1;

        do{
            System.out.print(test);
            System.out.println("\nMark(1) or Uncover a tile?(2)");
            action = input.nextInt();
            if(action == 1)
            {
               System.out.println("Enter row and column of tile: ");
               x = input.nextInt();
               y = input.nextInt();
               test.bmark(x,y);
            }
            else if(action == 2)
            {
               System.out.println("Enter row and column of tile: ");
               x = input.nextInt();
               y = input.nextInt();
               test.buncover(x,y);
               if(test.bgetMine(x,y)==true)
               break;
            }
        }while (7<8);
        System.out.println(test);
        System.out.println("ey mang u lossed");
        
    }

        //play(xCo,yCo, mines, test);
    }
//     public void play(int x, int y, int mines, GameBoard test)
//     {
//         Scanner input = new Scanner(System.in);
//         String action = new String("");
//         int xCo=0;
//         int yCo=0;
//         do{
//             System.out.print(test);
//             System.out.println("(M)ark or (U)ncover a tile?");
//             action = input.next();
//             if(action == "m" || action == "M")
//             {
//                System.out.println("Enter row and column of tile: ");
//                xCo = input.nextInt();
//                yCo = input.nextInt();
//                test[xCo][yCo].mark();
//             }
//             else if(action == "u" || action == "U")
//             {
//                System.out.println("Enter row and column of tile: ");
//                xCo = input.nextInt();
//                yCo = input.nextInt();
//                test[xCo][yCo].uncover();
//             }
//         }while (test[xCo][yCo].getMine()==false);
//         
//         System.out.println("ey mang u lossed");
//         
//     }

        