public class WeightedQuickUnionUF {

    private int[] id;
    private int[] sz;
    private int[] rootMax;
    private boolean[] isRemove;
    private final int SIZE;

    public WeightedQuickUnionUF(int N){
        id = new int[N];
        sz = new int[N];
        isRemove = new boolean[N];
        SIZE = N;
        rootMax = new int[N];

        for(int i=0;i<N;i++) {
            id[i] = i;
            sz[i] = 1;
            rootMax[i] = i;
            isRemove[i] = false;
        }
    }

    private int root(int i){
        while(id[i]!=i){
            i = id[i];
        }
        return i;
    }

    public boolean connected(int i, int j){
        return root(i)==root(j);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        int u = rootMax[i];
        int v = rootMax[j];

        if(i==j) return;
        if(sz[j]>sz[i]){
            id[i] = j;
            sz[j] += sz[i];
        }
        else{
            id[j] = i;
            sz[i] += sz[j];
        }

        if(u>v) rootMax[j] = rootMax[i] ;
        else rootMax[i] = rootMax[j];

    }

    public int find(int i){
        return rootMax[root(i)];
    }

    public int findSuccessor(int i){
        if(!isRemove[i]) return i;
        if(find(i)+1<SIZE) return find(i)+1;
        else return -1;

    }

    public void remove(int x){
        isRemove[x] = true;
        if(x+1<SIZE&&isRemove[x+1]) union(x+1,x);
        if(x-1>=0&&isRemove[x-1]) union(x-1,x);

    }

    public static void main(String[] args){
        WeightedQuickUnionUF union = new WeightedQuickUnionUF(10);
        union.remove(1);
        union.remove(2);
        union.remove(5);
        union.remove(6);
        System.out.println(union.findSuccessor(2));
        System.out.println(union.findSuccessor(5));
    }
}
