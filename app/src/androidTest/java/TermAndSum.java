import java.util.*;

class TermSum{
    float term, sum;
    Scanner sc  = new Scanner(System.in);
    public float apTerm(float s[], int n, float d){
        term = s[0] + (n-1)*d;
        return term;
    }
    public float apSum(float s[], int n, float d){
        sum = (n/2.0f)*(2*s[0]+(n-1)*d);
        return sum;
    }
    public float gpTerm(float s[], int n, float r){
        int i;
        term = s[0];
        for(i=0; i<n-1; i++){
            term *= r;
        }
        return term;
    }
    public float gpSum(float s[], int n, float r){
        float rn = 1;
        int i;
        for(i=0; i<n; i++){
            rn *= r;
        }
        if(r>1){
            sum = (s[0]*(rn-1))/(r-1);
        }
        else if(r<1){
            sum = (s[0]*(1-rn))/(1-r);
        }
        else{
            sum = n*s[0];
        }
        return sum;
    }
    public float hpTerm(float s[], int n, float d){
        term = (1/(1/s[0] + (n-1)*d));
        return term;
    }
    public float hpSum(float s[], int n, float d){
        sum = 0;
        int i;
        for(i=0; i<n; i++){
            sum += 1/((1/s[0])+(d*i));
        }
        return sum;
    }
    public int input1(){
        System.out.println("Enter no. of terms you want to enter: ");
        return sc.nextInt();
    }
    public int input2(){
        System.out.println("Enter the no. corresponding to the sequence you are entering:");
        System.out.println("1.AP\n2.GP\n3.HP");
        return sc.nextInt();
    }
    public float commonRatio(float[] s){
        return s[1]/s[0];
    }
    public float commonDifferenceAP(float[] s){
        return s[1] - s[0];
    }
    public float commonDifferenceHP(float[] s){
        return (1/s[1]) - (1/s[0]);
    }
    public void output(int c, int m){
        TermSum obj = new TermSum();
        int i, n;
        float d, r, sum, term;
        float[] s = new float[m];
        switch (c){
            case 1:
                System.out.println("Enter the AP sequence:");
                for(i=0; i<m; i++){
                    s[i] = sc.nextFloat();
                }
                d = commonDifferenceAP(s);
                System.out.print("Enter n: ");
                n = sc.nextInt();
                term = obj.apTerm(s, n, d);
                sum = obj.apSum(s, n, d);
                System.out.format("nth (%dth) term of the sequence is: %.0f\n", n, term);
                System.out.format("Sum of n (%d) terms of the sequence is: %.0f\n", n, sum);
                break;
            case 2:
                System.out.println("Enter the GP sequence:");
                for(i=0; i<m; i++){
                    s[i] = sc.nextFloat();
                }
                r = commonRatio(s);
                System.out.print("Enter n: ");
                n = sc.nextInt();
                term = obj.gpTerm(s, n, r);
                sum = obj.gpSum(s, n, r);
                System.out.format("nth (%dth) term of the sequence is: %.2f\n", n, term);
                System.out.format("Sum of n (%d) terms of the sequence is: %.2f\n", n, sum);
                break;
            case 3:
                System.out.println("Enter the HP sequence:");
                for(i=0; i<m; i++){
                    s[i] = sc.nextFloat();
                }
                d = commonDifferenceHP(s);
                System.out.print("Enter n: ");
                n = sc.nextInt();
                term = obj.hpTerm(s, n, d);
                sum = obj.hpSum(s, n, d);
                System.out.format("nth (%dth) term of the sequence is: %.2f\n", n, term);
                System.out.format("Sum of n (%d) terms of the sequence is: %.3f\n", n, sum);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }
}
public class TermAndSum {
    public static void main(String[] args){
        TermSum obj = new TermSum();
        int m = obj.input1();
        int c = obj.input2();
        obj.output(c, m);
    }
}
