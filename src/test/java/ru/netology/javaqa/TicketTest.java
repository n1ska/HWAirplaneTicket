package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void getFrom() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        String expected = "Sochi";

        Assertions.assertEquals(expected, ticket.getFrom());
    }

    @Test
    void getTo() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        String expected = "Krasnodar";

        Assertions.assertEquals(expected, ticket.getTo());
    }

    @Test
    void getPrice() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        int expected = 1290;

        Assertions.assertEquals(expected, ticket.getPrice());
    }

    @Test
    void getTimeFrom() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        int expected = 10;

        Assertions.assertEquals(expected, ticket.getTimeFrom());
    }

    @Test
    void getTimeTo() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        int expected = 15;

        Assertions.assertEquals(expected, ticket.getTimeTo());
    }

    @Test
    void testEqualsTheSameObject() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        Boolean expected = true;
        Boolean actual = ticket.equals(ticket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsNull() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        Boolean expected = false;
        Boolean actual = ticket.equals(null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsNotTheSameType() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        Boolean expected = false;
        Boolean actual = ticket.equals(new TicketTest());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsPrice() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        Boolean expected = false;
        Boolean actual = ticket.equals(new Ticket("Sochi", "Krasnodar", 129, 10, 15));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsTo() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        Boolean expected = false;
        Boolean actual = ticket.equals(new Ticket("Sochi", "_Krasnodar", 1290, 10, 15));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsFrom() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        Boolean expected = false;
        Boolean actual = ticket.equals(new Ticket("_Sochi", "Krasnodar", 1290, 10, 15));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsTimeFrom() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        Boolean expected = false;
        Boolean actual = ticket.equals(new Ticket("Sochi", "Krasnodar", 1290, 12, 15));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsTimeTo() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        Boolean expected = false;
        Boolean actual = ticket.equals(new Ticket("Sochi", "Krasnodar", 1290, 10, 16));

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testHashCode() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);

        int actual = ticket.hashCode();
        int expected =  Objects.hash("Sochi", "Krasnodar", 1290, 10, 15);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void compareToAbove() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);
        Ticket ticket2 = new Ticket("Sochi", "Anapa", 590, 10, 12);

        int actual = ticket.compareTo(ticket2);
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void compareToEqual() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);
        Ticket ticket2 = new Ticket("Sochi", "Anapa", 1290, 10, 12);

        int actual = ticket.compareTo(ticket2);
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void compareToBelow() {
        Ticket ticket = new Ticket("Sochi", "Krasnodar", 1290, 10, 15);
        Ticket ticket2 = new Ticket("Sochi", "Anapa", 1590, 10, 12);

        int actual = ticket.compareTo(ticket2);
        int expected = -1;

        Assertions.assertEquals(actual, expected);
    }
}