package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class MergeSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        // TODO: implement merge sort
        if(a==null || a.length==0) {
            return;
        }
        T[] temp =  (T[])new Comparable[a.length];
        mergeSort(a, temp, 0, a.length-1 , comp);
    }

    private <T> void mergeSort(T[] a, T[] temp, int left, int right, Comparator<? super T> comp) {
       if(left>=right) {
           return;
       }
       int middle = (left+right)/2;
       mergeSort(a, temp, left, middle, comp);
       mergeSort(a, temp, middle+1, right, comp);
       merge(a, temp, left, middle, right, comp);
    }

    private <T> void merge(T[] a, T[] temp,  int left, int middle, int right, Comparator<? super T> comp) {
        int i = left;
        int j = middle+1;
        int k = left;

        while(i<=middle && j<=right) {
                if(comp.compare(a[i],a[j])<=0) {
                    temp[k++] = a[i++];
                }else {
                    temp[k++] = a[j++];
                }
            }

        while(i<=middle) {
            temp[k++] =  a[i++];
        }

        while(j<=right) {
            temp[k++] =  a[j++];
        }

        for(int k1=left;k1<=right;k1++) {
            a[k1]=temp[k1];
        }
    }
}
