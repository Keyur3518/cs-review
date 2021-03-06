package com.mmnaseri.cs.clrs.ch02.sp;

import com.mmnaseri.cs.qa.annotation.Complexity;
import com.mmnaseri.cs.qa.annotation.Quality;
import com.mmnaseri.cs.qa.annotation.Stage;

import java.util.Comparator;

/**
 * @author Mohammad Milad Naseri (mmnaseri@programmer.net)
 * @since 1.0 (7/11/15, 1:03 PM)
 */
@Quality(Stage.DOCUMENTED)
public class BruteForceInversionCounter<E extends Comparable<E>> implements InversionCounter<E> {

    private final Comparator<E> comparator;

    public BruteForceInversionCounter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     * This  method will go over all the items and compare each item with every other pairing to find out the number of inversions
     * @param items    the items
     * @return number of inversions
     */
    @Complexity("O(n^2)")
    @SafeVarargs
    @Override
    public final int count(E... items) {
        int inversions = 0;
        for (int i = 0; i < items.length; i++) {
            for (int j = i + 1; j < items.length; j++) {
                if (comparator.compare(items[i], items[j]) > 0) {
                    inversions ++;
                }
            }
        }
        return inversions;
    }
}
