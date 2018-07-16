//import java.lang.IllegalArgumentException;
//import edu.princeton.cs.algs4.StdRandom;
//import edu.princeton.cs.algs4.StdStats;
//import edu.princeton.cs.algs4.WeightedQuickUnionUF;
//
//public class Percolation {
//
//    private WeightedQuickUnionUF union;
//    private boolean[] openSites;
//    private final int SIZE, TOP_INDEX, BOTTOM_INDEX;
//
//    public Percolation(int n){
//        if(n<=0)
//            throw new IllegalArgumentException();
//        int nodesNum = n*n+2;
//        union = new WeightedQuickUnionUF(nodesNum);
//        openSites = new boolean[n*n];
//        SIZE = n;
//        TOP_INDEX = n*n;
//        BOTTOM_INDEX = n*n+1;
//    }
//
//    private int convert2index(int row, int col){
//        return( (row-1)*SIZE + (col-1));
//    }
//
//    private void assertIndex(int row, int col){
//        if(row<=0 || row >SIZE || col <=0 || row>SIZE)
//            throw new IllegalArgumentException();
//    }
//
//
//    public void open(int row, int col){
//        assertIndex(row, col);
//        openSites[convert2index(row,col)] = true;
//        connect2Adjacents(row, col);
//        connect2vertualbottom(row, col);
//        connect2virtualtop(row, col);
//    }
//
//    private void connect2Adjacents(int row, int col){
//        connect2bottom(row, col);
//        connect2top(row, col);
//        connect2left(row, col);
//        connect2right(row, col);
//    }
//
//    private void connect2top(int row, int col){
//        if(row>1&&isOpen(row-1, col)){
//            union.union(convert2index(row-1, col),convert2index(row, col));
//        }
//    }
//
//    private void connect2bottom(int row, int col){
//        if(row<SIZE&&isOpen(row+1, col)){
//            union.union(convert2index(row+1, col), convert2index(row, col));
//        }
//    }
//
//    private void connect2left(int row, int col){
//        if(col>1&&isOpen(row, col-1)){
//            union.union(convert2index(row,col-1),convert2index(row, col));
//        }
//    }
//
//    private void connect2right(int row, int col){
//        if(col<SIZE&&isOpen(row, col+1)){
//            union.union(convert2index(row, col+1), convert2index(row, col));
//        }
//    }
//
//    private void connect2virtualtop(int row, int col){
//        if(row==1){
//            union.union(TOP_INDEX, convert2index(row, col));
//        }
//    }
//
//    private void connect2vertualbottom(int row, int col){
//        if(row == SIZE){
//            union.union(BOTTOM_INDEX, convert2index(row, col));
//        }
//    }
//
//    public boolean isOpen(int row, int col){
//        return openSites[convert2index(row, col)];
//    }
//
//    public boolean isFull(int row, int col){
//        assertIndex(row, col);
//        return union.connected(convert2index(row, col), TOP_INDEX);
//    }
//
//    public int numberofOpenSites(){
//        int count = 0;
//        for(int i=0;i<openSites.length;i++)
//            if(openSites[i])
//                count++;
//        return count;
//    }
//
//    public boolean percplates(){
//        return union.connected(BOTTOM_INDEX, TOP_INDEX);
//    }
//
//}
