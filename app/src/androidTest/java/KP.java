import java.util.Scanner;

class KP{
    double sum, sumDash, sumDashSquare;
    int i, j;
    double[] getX(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.trim();
        double[] x = new double[s.length()];
        String s2 = "";
        j = 0;
        for(i = 0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                s2 = s2 + s.charAt(i);
            }
            else{
                if (!s2.isEmpty()){
                    x[j] = Double.parseDouble(s2);
                    j++;
                    s2 = "";
                }
            }
        }
        x[j] = Double.parseDouble(s2);
        double[] x1 = new double[j+1];
        for(i = 0; i <= j; i++){
            x1[i] = x[i];
        }
        return x1;
    }

    double[] getY(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.trim();
        double[] y = new double[s.length()];
        String s2 = "";
        j = 0;
        for(i = 0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                s2 = s2 + s.charAt(i);
            }
            else{
                if (!s2.isEmpty()){
                    y[j] = Double.parseDouble(s2);
                    j++;
                    s2 = "";
                }
            }
        }
        y[j] = Double.parseDouble(s2);
        double[] y1 = new double[j+1];
        for(i = 0; i <= j; i++){
            y1[i] = y[i];
        }
        return y1;
    }

    double xBar(double x[]) {
        sum = 0;
        for (double i : x) {
            sum += i;
        }
        return sum / x.length;
    }
    double yBar(double y[]) {
        sum = 0;
        for (double i : y) {
            sum += i;
        }
        return sum / y.length;
    }
    double xyDash(double x[], double xBar, double y[], double yBar){
        for(int i = 0; i<x.length; i++){
            sumDash += (x[i] - xBar)*(y[i] - yBar);
        }
        return sumDash;
    }
    double xDashSquare(double x[], double xBar){
        sumDashSquare = 0;
        for(double i : x){
            sumDashSquare += (i - xBar)*(i - xBar);
        }
        return sumDashSquare;
    }
    double yDashSquare(double y[], double yBar){
        sumDashSquare = 0;
        for(double i : y){
            sumDashSquare += (i - yBar)*(i - yBar);
        }
        return sumDashSquare;
    }
    double kpCoeff(double sumDashXY, double sumDashSquareX, double sumDashSquareY){
        return (sumDashXY)/Math.sqrt(sumDashSquareX*sumDashSquareY);
    }
}

class KarlPearson {
    public static void main(String[] args){
//        double[] x = {65, 66, 67, 67, 68, 69, 70, 72};
//        double[] y = {66, 69, 65, 68, 72, 72, 70, 70};

        KP cc = new KP();
        double[] x = cc.getX();
        double[] y = cc.getY();
        double xBar = cc.xBar(x);
        double yBar = cc.yBar(y);
        double sumDashXY = cc.xyDash(x, xBar, y, yBar);
        double sumDashSquareX = cc.xDashSquare(x, xBar);
        double sumDashSquareY = cc.yDashSquare(y, yBar);
        double ans = cc.kpCoeff(sumDashXY, sumDashSquareX, sumDashSquareY);
        System.out.println("\t" + ans);
    }
}
