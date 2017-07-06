package com.epam.tdd;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class RangeTest {
    private Range one;
    private Range equalsToOne;
    private Range another;
    private Range negative;
    private Range fullRange;
    private Range fromMinToZero;
    private Range fromZeroToMax;

    @Before
    public void init() throws Exception {
        one = new Range(1, 25);
        equalsToOne = new Range(1, 25);
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
        assertThat(one.isBefore(equalsToOne), is(false));
    }

    @Test (expected = NullPointerException.class)
    public void isAfterNullArgsTest() throws Exception {
        one.isBefore(null);
    }

    @Test
    public void isAfterReturnsTrueTest() throws Exception {
        assertThat(one.isAfter(negative), is(true));
    }

    @Test
    public void isAfterReturnsFalseTest() throws Exception {
        assertThat(fromMinToZero.isAfter(fullRange), is(false));
    }

    @Test (expected = NullPointerException.class)
    public void isConcurrentNullArgsTest() throws Exception{
    }

    @Test
    public void isConcurrentReturnsTrueTest() throws Exception{
        assertThat(one.isConcurrent(another), is(true));
        assertThat(another.isConcurrent(one), is(true));
    }

    @Test
    public void isConcurrentReturnsFalseTest() throws Exception{
        assertThat(one.isConcurrent(negative), is(false));
        assertThat(negative.isConcurrent(one), is(false));
    }


    @Test
    public void testThatLowerBoundIsCorrect() throws Exception {
        assertThat(negative.getLowerBound(), is(-100L));
    }

    @Test
    public void testThatLowerBoundIsNotCorrect()throws Exception {
        assertFalse(negative.getLowerBound() == 50L);
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
