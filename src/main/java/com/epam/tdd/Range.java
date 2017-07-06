package com.epam.tdd;

import lombok.Setter;
import lombok.Getter;

import java.util.Iterator;
import java.util.List;


@Getter
@Setter
public class Range implements RangeInterface{
    private long start;
    private long end;

    public Range(long start, long end) {
        if (start >= end){
            throw new IllegalArgumentException("Start value should be lower than end");
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean isBefore(Range otherRange) {
        return this.start < otherRange.start;
    }

    @Override
    public boolean isAfter(Range otherRange) {
        return this.end > otherRange.end;
    }

    @Override
    public boolean isConcurrent(Range otherRange) {
        return false;
    }

    @Override
    public long getLowerBound() {
        return 0;
    }

    @Override
    public long getUpperBound() {
        return 0;
    }

    @Override
    public boolean contains(long value) {
        return false;
    }

    @Override
    public List<Long> asList() {
        return null;
    }

    @Override
    public Iterator<Long> asIterator() {
        return null;
    }
}