package ru.netology.javaqa63;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket(
            "Владивосток",
            "Москва",
            18_000,
            6,
            15
    );
    Ticket ticket2 = new Ticket(
            "Омск",
            "Москва",
            9_500,
            7,
            11
    );
    Ticket ticket3 = new Ticket(
            "Москва",
            "Омск",
            7_000,
            10,
            16
    );
    Ticket ticket4 = new Ticket(
            "Новосибирск",
            "Москва",
            14_000,
            6,
            10
    );

    Ticket ticket5 = new Ticket(
            "Махачкала",
            "Москва",
            7_000,
            15,
            19
    );

    Ticket ticket6 = new Ticket(
            "Махачкала",
            "Москва",
            6_000,
            17,
            20
    );

    Ticket ticket7 = new Ticket(
            "Махачкала",
            "Москва",
            4_500,
            21,
            23
    );

    TicketTimeComparator timeComparator = new TicketTimeComparator();

    @Test
    public void shouldBeMoreCompareTo() {

        int expected = 0;
        int actual = ticket1.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeLessCompareTo() {

        int expected = -1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeEqualCompareTo() {

        int expected = 1;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortSearch() {

        AviaSouls avia = new AviaSouls();
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);

        Ticket[] expected = {ticket7, ticket6, ticket5};
        Ticket[] actual = avia.search("Махачкала", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOne() {

        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket4);

        Ticket[] expected = {ticket4};
        Ticket[] actual = avia.search("Новосибирск", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoOne() {

        AviaSouls avia = new AviaSouls();
        avia.add(ticket3);
        avia.add(ticket4);

        Ticket[] expected = {};
        Ticket[] actual = avia.search("Баку", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeMoreComparator() {

        int expected = 1;
        int actual = timeComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeLessComparator() {

        int expected = -1;
        int actual = timeComparator.compare(ticket2, ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeEqualComparator() {

        int expected = 0;
        int actual = timeComparator.compare(ticket4, ticket5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortSearchAndSortBy() {

        AviaSouls avia = new AviaSouls();
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);

        Ticket[] expected = {ticket7, ticket6, ticket5};
        Ticket[] actual = avia.searchAndSortBy("Махачкала", "Москва", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortSearchOne() {

        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);

        Ticket[] expected = {ticket1};
        Ticket[] actual = avia.searchAndSortBy("Владивосток", "Москва", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortSearchNoOne() {

        AviaSouls avia = new AviaSouls();
        avia.add(ticket2);
        avia.add(ticket3);

        Ticket[] expected = {};
        Ticket[] actual = avia.searchAndSortBy("Махачкала", "Москва", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}