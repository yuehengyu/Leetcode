package com.yhy.leetcode;

public class Leetcode204_CountPrimes {

    public int countPrimes1(int n) {

        if (n <= 1)
            return 0;
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int j = i; i * j < n; j++) {//注意这里的索引值，答案都是从2开始 我个人认为从i开始就可以了 2*3 = 3*2
                    notPrime[j * i] = true;
                }
            }
        }

        int res = 0;
        for (boolean noPrime : notPrime) {
            if (!noPrime)
                res++;
        }
        return res;
    }

    public int countPrimes2(int n) {
        int res = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {//注意这里的索引 不能从0开始
            if (!notPrime[i]) {
                res++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[j * i] = true;
                }
            }
        }
        return res;
    }
}
