public class MinHeap{
    public static int heapSize = 0;
    public static int INF = 1000000;
    public static int treeArraySize = 1000;

    static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int rightChild(int [] A, int i) {
        if((((2*i)+1) < A.length && (i >= 1)))
            return (2*i)+1;
        return -1;
    }

    public static int leftChild(int [] A, int i) {
        if(((2*i) < A.length && (i >= 1)))
            return 2*i;
        return -1;
    }

    public static int Parent(int [] A, int i) {
        if ((i > 1) && (i < A.length)) {
            return i/2;
        }
        return -1;
    }
    public static void minHeapify(int [] A, int i)
    {
        int leftIndex = leftChild(A, i);
        int rightIndex = rightChild(A, i);


        int smallest = i;

        if ((leftIndex <= heapSize) && (leftIndex>0)) {
            if (A[leftIndex] < A[smallest]) {
                smallest = leftIndex;
            }
        }

        if ((rightIndex <= heapSize && (rightIndex>0))) {
            if (A[rightIndex] < A[smallest]) {
                smallest = rightIndex;
            }
        }


        if (smallest != i) {
            swap(A, smallest, i);
            minHeapify(A, smallest);
        }
    }

    public static void buildMinHeap(int [] A) {
        for(int i=heapSize/2; i>=1; i--) {
            minHeapify(A, i);
        }
    }

    public static int min(int[] A) {
        return A[1];
    }

    public static int extractMin(int [] A) {
        int min = A[1];
        A[1] = A[heapSize];
        heapSize--;
        minHeapify(A, 1);
        return min;
    }

    public static void decreaseKey(int [] A, int i, int key) {
        A[i] = key;
        while((i>1) && (A[Parent(A, i)] > A[i])) {
            int temp;
            temp = A[Parent(A, i)];
            A[Parent(A, i)] = A[i];
            A[i] = temp;
            i = Parent(A, i);
        }
    }

    public static void insert(int [] A, int key) {
        heapSize++;
        A[heapSize] = INF;
        decreaseKey(A, heapSize, key);
    }

    public static void printHeap(int [] A) {
        for(int i=1; i<=heapSize; i++) {
            System.out.println(A[i]);
        }
    }
    public static void heapSort(int [] A){
        buildMinHeap(A);
        int s = heapSize;
        for(int i = heapSize; i==1; i--){
            swap(A, 0, 1);
            s--;
            minHeapify(A,0);
        }
    }

    public static void main(String[] args) {
        int [] A = new int[treeArraySize];
        buildMinHeap(A);

        insert(A, 40);
        insert(A, 12);
        insert(A, 18);
        insert(A, 1);
        insert(A, 35);
        insert(A, 6);
        insert(A, 3);
        insert(A, 2);
        insert(A, 5);
        insert(A, 6);


        printHeap(A);

        System.out.println(min(A));
        //System.out.println(extractMin(A));
        //System.out.println(extractMin(A));
        //System.out.println(extractMin(A));
        //System.out.println(extractMin(A));
        //System.out.println(extractMin(A));
        //System.out.println(extractMin(A));
        //heapSort(A);
        //printHeap(A);
        //printHeap(A);

        //System.out.println(extractMin(A));

    }
}