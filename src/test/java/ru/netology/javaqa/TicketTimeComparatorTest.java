package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTimeComparatorTest {
    @Test
    void compare() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket[] tickets = new Ticket[]{
                new Ticket("Krasnodar", "Rostov", 110, 9, 11),
                new Ticket("Krasnodar", "Sochi", 100, 9, 11),
                new Ticket("Krasnodar", "Simpferopol", 120, 9, 10),
                new Ticket("Sochi", "Moscow", 140, 9, 16)
        };

        Arrays.sort(tickets, comparator);
        Ticket[] expected = new Ticket[]{
                new Ticket("Krasnodar", "Simpferopol", 120, 9, 10),
                new Ticket("Krasnodar", "Rostov", 110, 9, 11),
                new Ticket("Krasnodar", "Sochi", 100, 9, 11),
                new Ticket("Sochi", "Moscow", 140, 9, 16)
        };

        Assertions.assertArrayEquals(expected, tickets);
    }
}