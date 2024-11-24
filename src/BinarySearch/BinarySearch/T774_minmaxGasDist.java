package src.BinarySearch.BinarySearch;

public class T774_minmaxGasDist {

    /**
     * https://leetcode.cn/problems/minimize-max-distance-to-gas-station/
     * @param stations
     * @param k
     * @return
     */

    public double minmaxGasDist(int[] stations, int k) {


        double l=0;
        double r=Integer.MIN_VALUE;
        for (int i = 0; i < stations.length-1; i++) {
            r= Math.max(r,stations[i+1]-stations[i]);
        }
        double diff=0.000001;
        while (r-l>diff){
            double mid=(l+r)/2;
            if(check(stations,k,mid)){
                r=mid;
            }else {
                l=mid;
            }

        }

        return l;
    }


    public boolean check(int[] stations, int k,double disTarget){
        for (int i = 0; i < stations.length-1; i++) {
           double dis=stations[i+1]-stations[i];
           if(dis>disTarget){
               k-=Math.floor(dis/disTarget);

               if(k<0){return false;}
           }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] stations = new int[]{1,2,3,4,5,6,7,8,9,10};
        int k = 9;

        stations = new int[]{23,24,36,39,46,56,57,65,84,98};
        k = 1;


        System.out.println(new T774_minmaxGasDist().minmaxGasDist(stations,k));
//        System.out.println(new T774_minmaxGasDist().check(stations,k,9.5));
    }
}
