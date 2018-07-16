//import java.lang.IllegalArgumentException;
//
//public class PercolationStats {
//
//    private double [] result;
//
//    public PercolationStats(int n, int trials){
//        assertArgs(n, trials);
//        result = new double[trials];
//        experiment(n, trials);
//    }
//
//    private void assertArgs(int n, int trials){
//        if(n<=0||trials<=0)
//            throw new IllegalArgumentException();
//    }
//    private void experiment(int n, int trials){
//        for(int i=0;i<trials;i++){
//            Percolation p = new Percolation(n);
//            int openSites = 0;
//            while(!p.percplates()){
//                int row = random(n);
//                int col = random(n);
//                if(!p.isOpen(row, col)){
//                    p.open(row, col);
//                    openSites++;
//                }
//            }
//            result[i] = openSites / (n*n);
//        }
//    }
//
//    private int random(int size) {
//        return StdRandom.uniform(1, size + 1);
//    }
//
//    public double mean(){
//        return StdStats.mean(result);
//    }
//
//    public double stddev(){
//        return StdStats.stddev(result);
//    }
//
//    public double confidenceLo(){
//        return mean() - 1.96*stddev()/Math.sqrt(result.length);
//    }
//
//    public double confidenceHi(){
//        return mean() + 1.96*stddev()/Math.sqrt(result.length);
//    }
//
//    public static void main(String[] args) {
//        PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
//        System.out.println("mean                    = " + stats.mean());
//        System.out.println("stddev                  = " + stats.stddev());
//        System.out.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi()+"]");
//    }
//}
//
