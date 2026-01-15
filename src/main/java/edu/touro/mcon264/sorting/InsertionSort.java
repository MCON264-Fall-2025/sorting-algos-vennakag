package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class InsertionSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        // TODO: implement insertion sort
        for (int i = 1; i < a.length; i++) {
            insertionSort(a,0,i,comp);
        }
    }
    public <T> void insertionSort(T[] a, int start, int end, Comparator<? super T> comp) {
        boolean finished = false;
        int curr = end;
        boolean moreToSearch = true;
        while(moreToSearch && !finished) {
            if (comp.compare(a[curr], a[curr - 1]) <= 0) {
                T temp = a[curr];
                a[curr] = a[curr - 1];
                a[curr - 1] = temp;
                curr--;
                moreToSearch = (curr!=start);
            }else{
                finished = true;
            }

        }
    }
}
