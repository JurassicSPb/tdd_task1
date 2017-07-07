package com.epam.tdd;

import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Getter
@Setter
public class Range implements RangeInterface {
    private long start;
    private long end;

    public Range(long start, long end) {
        if (start >= end) {
            throw new IllegalArgumentException("Start value should be lower than end");
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean isBefore(Range otherRange) {
        return this.end < otherRange.start;
    }

    @Override
    public boolean isAfter(Range otherRange) {
        return this.start > otherRange.end;
    }

    @Override
    public boolean isConcurrent(Range otherRange) {
        return !this.isBefore(otherRange) && !this.isAfter(otherRange);
    }

    @Override
    public long getLowerBound() {
        return start;
    }

    @Override
    public long getUpperBound() {
        return end;
    }

    @Override
    public boolean contains(long value) {
        return value >= start && value <= end;
    }

    @Override
    public List<Long> asList() {
        List <Long> buffer = new ArrayList<>();
        for (long i = start; i <= end; i++) {
            buffer.add(i);
        }
        return buffer;
    }

    @Override
    public Iterator<Long> asIterator() {
        return new Iterator<Long>() {
            long currentIndex = start;

            @Override
            public boolean hasNext() {
                return currentIndex <= end;
            }

            @Override
            public Long next() {
                if (currentIndex > end){
                    throw new IndexOutOfBoundsException();
                }
                return currentIndex++;
            }
        };
    }
}