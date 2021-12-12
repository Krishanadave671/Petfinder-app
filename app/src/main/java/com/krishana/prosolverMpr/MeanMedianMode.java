package com.krishana.prosolverMpr;

import java.util.Arrays;

class MMM{
    int i, j, n;

    int[] getArray(String s){

        s = s.trim();
        int[] x = new int[s.length()];
        String s2 = "";
        j = 0;
        for(i = 0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                s2 = s2 + s.charAt(i);
            }
            else{
                if (!s2.isEmpty()){
                    x[j] = Integer.parseInt(s2);
                    j++;
                    s2 = "";
                }
            }
        }
        x[j] = Integer.parseInt(s2);
        int[] x1 = new int[j+1];
        for(i = 0; i <= j; i++){
            x1[i] = x[i];
        }
        return x1;
    }

    public double mean(int a[]){
        int sum = 0;
        for(int i : a){
            sum += i;
        }

        return (double)sum/a.length;
    }

    public double median(int a[]){
        double median;
        if(a.length % 2 == 0){
            median = (a[a.length/2 - 1] + a[a.length/2])/2.0;
        }
        else{
            median = a[a.length/2];
        }
        return median;
    }

    public int[] mode(int a[]){
        int[] ele = new int[50];
        int[] count = new int[50];
        n = a.length;
        j = 0;
        for (i = 0; i < n; i++)
        {
            ele[i] = a[j];
            count[i] = 0;
            while (j < n) {
                if (a[j] == ele[i]) {
                    count[i]++;
                }
                else {
                    break;
                }
                j++;
            }
            if(j == n){
                break;
            }
        }
        int max = count[0];
        for (i = 0; i < n; i++){
            if(count[i] > max){
                max = count[i];
            }
        }
        j = 0;
        for (i = 0; i < n; i++){
            if(count[i] == max){
                j++;
            }
        }
        int[] mode = new int[j];
        j = 0;
        for (i = 0; i < n; i++){
            if(count[i] == max){
                mode[j] = ele[i];
                j++;
            }
        }
        return mode;
    }

    public double populationSD(int a[], double mean){
        double sum = 0;
        for (i = 0; i < a.length; i++){
            sum += (a[i] - mean)*(a[i] - mean);
        }
        return Math.sqrt(sum/a.length);
    }

    public double sampleSD(int a[], double mean){
        double sum = 0;
        for (i = 0; i < a.length; i++){
            sum += (a[i] - mean)*(a[i] - mean);
        }
        return Math.sqrt(sum/(a.length - 1));
    }

    public double populationVariance(int a[], double mean){
        double sum = 0;
        for (i = 0; i < a.length; i++){
            sum += (a[i] - mean)*(a[i] - mean);
        }
        return (sum/(a.length));
    }

    public double sampleVariance(int a[], double mean){
        double sum = 0;
        for (i = 0; i < a.length; i++){
            sum += (a[i] - mean)*(a[i] - mean);
        }
        return (sum/(a.length - 1));
    }
}

public class MeanMedianMode {
    public static void main(String[] args){
//        int[] a = {8, 3, 4, 7, 7, 2, 3, 6, 2, 6, 7, 4, 3, 7, 4, 1, 6, 6};
//        int[] a = {5, 6 ,10, 2, 9};
        MMM m = new MMM();
        int[] a = m.getArray("5 7 8 9");
        Arrays.sort(a);
        System.out.print("Sorted array is: ");
        for( int p : a){
            System.out.print(p + " ");
        }
        System.out.println("");
        int[] mode = m.mode(a);
        System.out.printf("\nMean is: %.3f\n", m.mean(a));

        System.out.printf("\nMedian is: %.3f\n", m.median(a));

        System.out.print("\nMode is: ");
        for (int j : mode) {
            System.out.print(j + " ");
        }

        System.out.println("\n\nPopulation Standard Deviation is: " + m.populationSD(a, m.mean(a)));
        System.out.println("\nSample Standard Deviation is: " + m.sampleSD(a, m.mean(a)));
        System.out.println("\nPopulation Variance is: " + m.populationVariance(a, m.mean(a)));
        System.out.println("\nSample Variance is: " + m.sampleVariance(a, m.mean(a)));

    }
}