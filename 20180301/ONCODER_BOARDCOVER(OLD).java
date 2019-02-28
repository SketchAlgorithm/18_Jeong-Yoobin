public class Solution{
    public int solution(String[] board){
        int returning = 0;      //정답
        int[][] _board = changetoeasy(board);
        
        if(_board == null)
            return 0;
        
        for(int i = 0; i<_board.length; i++) {
            for(int j = 0; j<_board[i].length; j++) {
                if(_board[i][j] == 0 && (i+j)%2 == 0)
                    returning += setL(_board, i, j);
            }
        }
        
        
        
        return returning;
    }
    
    public int[][] changetoeasy(String[] board) {   //0, 1, 2로 이루어지게 쉽게 바꾸기
        //0 빈칸
        //1 체스말
        //2 타일
        
        int[][] a = new int[board.length][];
        for(int i = 0; i<a.length; i++) {
            a[i] = new int[board[i].length()];
            for(int j = 0; j<a[i].length; j++)
                if(board[i].charAt(j) == 'X')
                    a[i][j] = 1;
                else
                    a[i][j] = 0;
            
        }
        if(a.length <2 || a[0].length < 2)
            return null;
        
        return a;
    }
    
    public int setL(int[][] _board, int x, int y) {
        if(x == 0) {
            if(y == 0) {
                if(_board[x+1][y] == 0 && _board[x][y+1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y+1] = 2;
                    _board[x+1][y] = 2;
                    return 1;
                }
                    
            } else if (y == _board.length - 1) {
                if(_board[x+1][y] == 0 && _board[x][y-1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y-1] = 2;
                    _board[x+1][y] = 2;
                    return 1;
                }
            } else {
                
                 if(_board[x+1][y] == 0 && _board[x][y+1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y+1] = 2;
                    _board[x+1][y] = 2;
                    return 1;
                }if(_board[x+1][y] == 0 && _board[x][y-1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y-1] = 2;
                    _board[x+1][y] = 2;
                    return 1;
                }
 
            }
        } else if (x == _board.length  - 1) {
            if(y == 0) {
                if(_board[x-1][y] == 0 && _board[x][y+1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y+1] = 2;
                    _board[x-1][y] = 2;
                    return 1;
                }
                    
            } else if (y == _board.length - 1) {
                if(_board[x-1][y] == 0 && _board[x][y-1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y-1] = 2;
                    _board[x-1][y] = 2;
                    return 1;
                }
            } else {
                if(_board[x-1][y] == 0 && _board[x][y-1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y-1] = 2;
                    _board[x-1][y] = 2;
                    return 1;
                }
                 if(_board[x-1][y] == 0 && _board[x][y+1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y+1] = 2;
                    _board[x-1][y] = 2;
                    return 1;
                }
 
            }
        } else {
            if(y == 0) {
                if(_board[x-1][y] == 0 && _board[x][y+1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y+1] = 2;
                    _board[x-1][y] = 2;
                    return 1;
                }
                if(_board[x+1][y] == 0 && _board[x][y+1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y+1] = 2;
                    _board[x+1][y] = 2;
                    return 1;
                }
                    
            } else if (y == _board.length - 1) {
                if(_board[x-1][y] == 0 && _board[x][y-1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y-1] = 2;
                    _board[x-1][y] = 2;
                    return 1;
                }
                if(_board[x+1][y] == 0 && _board[x][y-1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y-1] = 2;
                    _board[x+1][y] = 2;
                    return 1;
                }
            } else {
                if(_board[x-1][y] == 0 && _board[x][y-1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y-1] = 2;
                    _board[x-1][y] = 2;
                    return 1;
                }
                 if(_board[x-1][y] == 0 && _board[x][y+1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y+1] = 2;
                    _board[x-1][y] = 2;
                    return 1;
                }if(_board[x+1][y] == 0 && _board[x][y-1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y-1] = 2;
                    _board[x+1][y] = 2;
                    return 1;
                }
                 if(_board[x+1][y] == 0 && _board[x][y+1] == 0) {
                    _board[x][y] = 2;
                    _board[x][y+1] = 2;
                    _board[x+1][y] = 2;
                    return 1;
                }
 
            }
        }
        
        return 0;               //추가하지 않음
    }
}
