import java.util.Arrays;
public class Min
{
    public static int minSum(int[] passed){
        Arrays.sort(passed);
        int sum = 0;
        for(int i =0; i<(passed.length+1)/2; i++){
            for(int j = passed.length -1; j>(passed.length + 1)/2; j--){
                int product = passed[i]*passed[j];
                sum = sum + product;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] array = {5,2,3,4};
        minSum(array);

    }
}


