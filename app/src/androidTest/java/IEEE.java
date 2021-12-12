

import java.util.Scanner;

class convert{
    public float toDecimal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter IEEE no:");
        String s = sc.next();
        int i, intBit;
        float ans;
        String negativeString ="";
        if(s.length() == 32 && s.charAt(0) == 1) {
            for (i = 1; i < s.length(); i++) {
                negativeString = negativeString + s.charAt(i);
            }
            intBit = Integer.parseInt(negativeString, 2);
            ans = -1*(Float.intBitsToFloat(intBit));
        }
        else {
            intBit = Integer.parseInt(s, 2);
            ans = Float.intBitsToFloat(intBit);
        }
        return ans;
    }
    public String toIEEE(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter decimal no:");
        float f = sc.nextFloat();
        int bits = Float.floatToIntBits(f);
        String binary = Integer.toBinaryString(bits);
        String ans = "";
        if(binary.length() != 32){
            for(int i = 0; i < 32-binary.length(); i++){
                ans = ans + "0";
            }
            ans = ans + binary;
        }
        else {
            ans = binary;
        }
        return ans;
    }
    public String Seperate(String s){
        String seperatedString = s.charAt(0) + " | ";
        for(int i = 1; i < 9; i++){
            seperatedString = seperatedString + s.charAt(i);
        }
        seperatedString = seperatedString + " | ";
        for(int i = 9; i < 32; i++){
            seperatedString = seperatedString + s.charAt(i);
        }
        return seperatedString;
    }
}

public class IEEE {
    public static void main(String args[]) {
        convert c = new convert();
        System.out.println(c.Seperate(c.toIEEE()));
        System.out.println(c.toDecimal());
    }
}