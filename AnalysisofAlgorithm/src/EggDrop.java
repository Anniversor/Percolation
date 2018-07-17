public class EggDrop {


    private int version0(int []array, int limit){
        for(int i=0;i<array.length;i++)
            if(array[i]>=limit)
                return i+1;
        return array.length;
    }

    private int version1(int []array, int limit){
        int high = array.length-1;
        int low =1;
        while(high>=low){
            int mid = (high+low)/2;
            if(array[mid]<limit) low = mid+1;
            else if (array[mid-1]>=limit) high = mid-1;

            else if(array[mid]>=limit&&array[mid-1]<limit)
                return mid+1;
        }
        return 1;
    }

    private int version2(int[]array,int limit){
        int k;
        int high;
        int low;
        if(array[0]>=limit) return 1;

        for(k=1;k<array.length;k *= 2){
            if(array[k]>=limit)
                break;
        }

        low = k/2;
        if(k>array.length-1) {

            k = array.length-1;
        }
        high = k;

        while(high>=low){
            int mid = (high+low)/2;
            if(array[mid]<limit) low = mid+1;
            else if (array[mid-1]>=limit) high = mid-1;
            else if(array[mid]>=limit&&array[mid-1]<limit)
                return mid+1;
        }
        return -1;
    }

    private int version3(int[] array,int limit){
        return 1;
    }

    public static void main(String[]args){
        EggDrop g = new EggDrop();
        int[] array = {1,2,5,6,7,8,9,18,20,88};
        System.out.println(g.version0(array,10));
        System.out.println(g.version1(array,10));
        System.out.println(g.version2(array,10));
    }
}