package sample1;

public class hello {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        if(game == null || game.length==1)
            return true;
        game[0] = -1;
        while(true){
            boolean bModify = false;
            for(int i = 0;i < game.length;i++){
                if(game[i]==-1){
                    if(i+leap>=game.length||i==game.length-1)
                        return true;
                    if(i-1>=0&&game[i-1]==0){
                        game[i-1]=-1;
                        bModify = true;
                    }
                    if(game[i+1]==0){
                        game[i+1]=-1;
                        bModify = true;
                    }
                    if(game[i+leap]==0){
                        game[i+leap]=-1;
                        bModify = true;
                    }
                    game[i]=1;
                }
            }
            if(!bModify)
                break;
        }
        return false;
    }

    public static void main(String args[]){
        int []arr = {0,0,0,0,0,1,1,1,0};
        System.out.println(canWin(3,arr));
    }
}
