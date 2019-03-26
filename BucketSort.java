public class BucketSort {

    static void bucketSort(int[] array, int k){
        ArrayList<Integer>[] buckets = new ArrayList[k];
        for(int i=0 ; i<k ; i++)
            buckets[i] = new ArrayList<Integer>();
        for(int i=0 ;i<array.length ; i++){
            int weight = array[i]%k;
            buckets[weight].add(array[i]);
        }
        for(int i=0 ;i<k ; i++)
        Collections.sort(buckets[i]);

        for(int i=k-1;i>=0 ; i--)
           for(int ele : buckets[i])
              System.out.print(ele + " ");

    }
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int arrLen = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[arrLen];
        for(int i=0 ;i<arrLen ; i++)
        array[i] = sc.nextInt();


        bucketSort(array,k);


    }
}
