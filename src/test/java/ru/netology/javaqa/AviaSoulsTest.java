package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    @Test
    void add() {
        AviaSouls souls = new AviaSouls();
        souls.add(new Ticket("Simpheropol", "Kransodar", 100, 10, 12));

        Ticket[] expected = new Ticket[]{
                new Ticket("Simpheropol", "Kransodar", 100, 10, 12)
        };
        Ticket[] actual = souls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        AviaSouls souls = new AviaSouls();
        souls.add(new Ticket("Simpheropol", "Kransodar", 100, 10, 12));
        souls.add(new Ticket("Simpheropol", "Moscow", 200, 10, 16));

        Ticket[] expected = new Ticket[]{
                new Ticket("Simpheropol", "Kransodar", 100, 10, 12),
                new Ticket("Simpheropol", "Moscow", 200, 10, 16)
        };
        Ticket[] actual = souls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void search() {
        AviaSouls souls = new AviaSouls();
        souls.add(new Ticket("Simpheropol", "Kransodar", 100, 10, 12));
        souls.add(new Ticket("Simpheropol", "Moscow", 200, 10, 16));

        Ticket[] expected = new Ticket[]{
                new Ticket("Simpheropol", "Moscow", 200, 10, 16)
        };
        Ticket[] actual =  souls.search("Simpheropol", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchWithSortByPriceAscending() {
        AviaSouls souls = new AviaSouls();
        souls.add(new Ticket("Simpheropol", "Kransodar", 100, 10, 12));
        souls.add(new Ticket("Simpheropol", "Moscow", 200, 10, 16));
        souls.add(new Ticket("Simpheropol", "Moscow", 100, 11, 16));

        Ticket[] expected = new Ticket[]{
                new Ticket("Simpheropol", "Moscow", 100, 11, 16),
                new Ticket("Simpheropol", "Moscow", 200, 10, 16)
        };
        Ticket[] actual =  souls.search("Simpheropol", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchAndSortBy() {
        AviaSouls souls = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        souls.add(new Ticket("Simpheropol", "Kransodar", 100, 10, 12));
        souls.add(new Ticket("Moscow", "Simpheropol", 210, 12, 18));
        souls.add(new Ticket("Simpheropol", "Moscow", 210, 12, 18));
        souls.add(new Ticket("Simpheropol", "Moscow", 200, 10, 15));
        souls.add(new Ticket("Simpheropol", "Moscow", 200, 10, 16));

        Ticket[] expected = new Ticket[]{
                new Ticket("Simpheropol", "Moscow", 200, 10, 15),
                new Ticket("Simpheropol", "Moscow", 200, 10, 16),
                new Ticket("Simpheropol", "Moscow", 210, 12, 18)
        };
        Ticket[] actual =  souls.searchAndSortBy("Simpheropol", "Moscow", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}