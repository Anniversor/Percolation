public class bitonicSearch {



    public boolean bitonicsearch(int[] array, int n){
        int peak = findPeak(array);
        int a = binarySearch(array, n, 0, peak);
        int b = binarySearch(array, n, 1, peak);
        if(a!=-1||b!=-1)
            return true;
        return false;
    }

    public int binarySearch(int[] a, int key, int flag, int k){
        int lo, hi;

        if(flag ==0){
             lo = 0;
             hi = k;
        }
        else{
            lo = k;
            hi = a.length-1;
        }


        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(key>a[mid]) hi = mid-1;
            else if(key<a[mid]) lo = mid+1;
            else return mid;
        }

        return -1;
    }

    private int findPeak(int [] array){
        int low = 0;
        int high = array.length-1;
        int mid = (low+high)/2;
        while(mid<(array.length-1)&&mid>=1&&high>=low){
            if(array[mid]>array[mid-1]&&array[mid]<array[mid+1]){
                low = mid+1;
            }

            else if(array[mid]>array[mid+1]&&array[mid]<array[mid-1]){
                high = mid-1;
            }

            else if(array[mid]>array[mid-1]&&array[mid]>array[mid+1])
                return mid;

            mid = (low+high)/2;
        }
        return mid;
    }

    public static void main(String[] args){
        bitonicSearch b = new bitonicSearch();

        int[] array = {1,2,8,1,0};
        System.out.println(b.findPeak(array));
        System.out.println(b.bitonicsearch(array,8));
        System.out.println(b.bitonicsearch(array,5));
        System.out.println(b.bitonicsearch(array,-1));
        System.out.println(b.bitonicsearch(array,0));
    }
}
