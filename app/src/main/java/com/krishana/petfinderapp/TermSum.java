package com.krishana.petfinderapp;

public class TermSum {
    double term, sum;


    public double apSum(double a, int n, double d) {
        sum = (n / 2) * (2 * a + (n - 1) * d);
        return sum;
    }

    public double gpTerm(float s[], int n, float r) {
        int i;
        term = s[0];
        for (i = 0; i < n - 1; i++) {
            term *= r;
        }
        return term;
    }

    public double gpSum(float s[], int n, float r) {
        float rn = 1;
        int i;
        for (i = 0; i < n; i++) {
            rn *= r;
        }
        if (r > 1) {
            sum = (s[0] * (rn - 1)) / (r - 1);
        } else if (r < 1) {
            sum = (s[0] * (1 - rn)) / (1 - r);
        } else {
            sum = n * s[0];
        }
        return sum;
    }

    public double hpTerm(float s[], int n, float d) {
        term = (1 / (1 / s[0] + (n - 1) * d));
        return term;
    }

    public double hpSum(float s[], int n, float d) {
        sum = 0;
        int i;
        for (i = 0; i < n; i++) {
            sum += 1 / ((1 / s[0]) + (d * i));
        }
        return sum;
    }
}