package Arrays.d11;

public class PowFunction {
    public static void main(String[] args) {

        long x = 2l;
        int pow  =20;

        while (pow%2== 0){
            x*=x;
            pow = pow/2;
        }

        for(int i =1;i<=pow; i++){
            x*=x;
        }

        System.out.println(x);
    }
}
