package com.epam.tdd;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

import com.epam.tdd.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
    private Range one;
    private Range another;
    private Range negative;
    private Range reverseNegative;
    private Range fullRange;
    private Range fromMinToZero;
    private Range fromZeroToMax;

    @Before
    public void init() throws Exception {
        one = new Range(1, 25);
        another = new Range(5, 50);
        negative = new Range(-100, -5);
        fullRange = new Range(Long.MIN_VALUE, Long.MAX_VALUE);
        fromMinToZero = new Range(Long.MIN_VALUE, 0);
        fromZeroToMax = new Range(0, Long.MAX_VALUE);
    }

    @Test
    public void initWrongContractTest() throws Exception {
        try {
            Range reverse = new Range(50, 5);
            reverse.isAfter(negative);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Start value should be lower than end");
        }
    }

    @Test(expected = NullPointerException.class)
    public void isBeforeNullArgsTest() throws Exception {
        one.isBefore(null);
    }

    @Test
    public void isBeforeReturnsTrueTest() throws Exception {
        assertThat(one.isBefore(another), is(true));
    }

    @Test
    public void isBeforeReturnsFalseTest() throws Exception {
        assertThat(another.isBefore(one), is(false));
    }

    @Test
    public void isAfter() {
    }

    @Test
    public void isConcurrent() {
    }

    @Test
    public void getLowerBound() {
    }

    @Test
    public void getUpperBound() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void asList() {
    }

    @Test
    public void asIterator() {
    }
}
