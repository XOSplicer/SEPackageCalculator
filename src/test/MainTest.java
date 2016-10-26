package test;

import org.junit.Test;
import packagecalculator.model.Item;
import packagecalculator.model.Model;
import packagecalculator.model.ShippingCostCalculatable;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Felix Stegmaier on 26.10.2016.
 */
public class MainTest {

    @Test
    public void test1() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[4];
        books[0] = new Item();
        books[0].setLength(300);
        books[0].setWidth(200);
        books[0].setHeight(10);
        books[0].setWeight(500);
        books[1] = new Item();
        books[1].setLength(300);
        books[1].setWidth(200);
        books[1].setHeight(10);
        books[1].setWeight(600);
        books[2] = new Item();
        books[2].setLength(300);
        books[2].setWidth(200);
        books[2].setHeight(10);
        books[2].setWeight(700);
        books[3] = new Item();
        books[3].setLength(300);
        books[3].setWidth(200);
        books[3].setHeight(10);
        books[3].setWeight(800);
        assertEquals("4 A4 books", 6.99, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test
    public void test2() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[5];
        books[0] = new Item();
        books[0].setLength(100);
        books[0].setWidth(300);
        books[0].setHeight(10);
        books[0].setWeight(200);
        books[1] = new Item();
        books[1].setLength(200);
        books[1].setWidth(200);
        books[1].setHeight(20);
        books[1].setWeight(300);
        books[2] = new Item();
        books[2].setLength(300);
        books[2].setWidth(100);
        books[2].setHeight(30);
        books[2].setWeight(200);
        books[3] = new Item();
        books[3].setLength(200);
        books[3].setWidth(200);
        books[3].setHeight(40);
        books[3].setWeight(200);
        books[4] = new Item();
        books[4].setLength(100);
        books[4].setWidth(300);
        books[4].setHeight(50);
        books[4].setWeight(100);
        assertEquals("maximal smallest packet", 4.00, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test
    public void test3() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[7];
        books[0] = new Item();
        books[0].setLength(300);
        books[0].setWidth(200);
        books[0].setHeight(10);
        books[0].setWeight(500);
        books[1] = new Item();
        books[1].setLength(300);
        books[1].setWidth(200);
        books[1].setHeight(10);
        books[1].setWeight(600);
        books[2] = new Item();
        books[2].setLength(300);
        books[2].setWidth(200);
        books[2].setHeight(10);
        books[2].setWeight(700);
        books[3] = new Item();
        books[3].setLength(300);
        books[3].setWidth(200);
        books[3].setHeight(10);
        books[3].setWeight(800);
        books[4] = null;
        books[5] = null;
        books[6] = null;
        assertEquals("some books not entered", 6.99, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test
    public void test4() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(300);
        books[0].setWidth(200);
        books[0].setHeight(10);
        books[0].setWeight(500);
        assertEquals("Single A4 light book", 4.00, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test
    public void test5() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[3];
        books[0] = new Item();
        books[0].setLength(-10);
        books[0].setWidth(0);
        books[0].setHeight(0);
        books[0].setWeight(0);
        books[1] = new Item();
        books[1].setLength(100);
        books[1].setWidth(10);
        books[1].setHeight(10);
        books[1].setWeight(1000);
        books[2] = new Item();
        books[2].setLength(100);
        books[2].setWidth(10);
        books[2].setHeight(10);
        books[2].setWeight(1000);
        assertEquals("One negative, other normal", Double.NaN, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test
    public void test6() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(-10);
        books[0].setWidth(0);
        books[0].setHeight(0);
        books[0].setWeight(-2000);
        assertEquals("Negative Input", Double.NaN, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test(expected = NumberFormatException.class)
    public void test7() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(Integer.parseInt("hello"));
        books[0].setWidth(0);
        books[0].setHeight(0);
        books[0].setWeight(0);
        assertEquals("text input", Double.NaN, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test(expected = NumberFormatException.class)
    public void test8() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(Integer.parseInt("10cm"));
        books[0].setWidth(Integer.parseInt("30cm"));
        books[0].setHeight(Integer.parseInt("10cm"));
        books[0].setWeight(Integer.parseInt("3kg"));
        assertEquals("text input", Double.NaN, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test
    public void test9() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(500);
        books[0].setWidth(300);
        books[0].setHeight(30);
        books[0].setWeight(1900);
        assertEquals("standard big parcel", 4.50, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test
    public void test10() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(500);
        books[0].setWidth(500);
        books[0].setHeight(150);
        books[0].setWeight(4500);
        assertEquals("standard packet", 6.99, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test
    public void test11() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(500);
        books[0].setWidth(500);
        books[0].setHeight(300);
        books[0].setWeight(9500);
        assertEquals("standard packet 10kg", 8.99, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test (expected = NumberFormatException.class)
    public void test12() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(500);
        books[0].setWidth(Integer.parseInt("1O"));
        books[0].setHeight(300);
        books[0].setWeight(9500);
        assertEquals("bad character input", Double.NaN, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test
    public void test13() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(500);
        books[0].setWidth(500);
        books[0].setHeight(300);
        books[0].setWeight(30000);
        assertEquals("standard heavy packet", 14.99, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test
    public void test14() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(1300);
        books[0].setWidth(500);
        books[0].setHeight(500);
        books[0].setWeight(5900);
        assertEquals("too large", Double.NaN, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test(expected = NumberFormatException.class)
    public void test15() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(Integer.parseInt("0xF"));
        books[0].setWidth(Integer.parseInt("0x9"));
        books[0].setHeight(Integer.parseInt("0x2"));
        books[0].setWeight(Integer.parseInt("0x2.C"));
        assertEquals("input as hexadecimal", Double.NaN, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test
    public void test16() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(1200);
        books[0].setWidth(500);
        books[0].setHeight(500);
        books[0].setWeight(1000);
        assertEquals("girth too high for std", 14.99, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test
    public void test17() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(500);
        books[0].setWidth(500);
        books[0].setHeight(300);
        books[0].setWeight((int) Double.parseDouble("0,5")*1000);
        assertEquals("input comma instead of dot", 6.99, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test
    public void test18() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(10);
        books[0].setWidth(300);
        books[0].setHeight(150);
        books[0].setWeight(1000);
        assertEquals("wrong input order", 4.00, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }

    @Test (expected = NumberFormatException.class)
    public void test19() {
        ShippingCostCalculatable scc = new Model();
        Item[] books = new Item[1];
        books[0] = new Item();
        books[0].setLength(Integer.parseInt("10,300,150,1000"));
        assertEquals("all input inside the first field", Double.NaN, scc.calcShippingCost(Arrays.asList(books)), 0.001);
    }









}