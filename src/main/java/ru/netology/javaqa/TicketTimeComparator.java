package ru.netology.javaqa;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    private int calculateDurationTime(Ticket ticket){
        return ticket.getTimeTo() - ticket.getTimeFrom();
    }

    @Override
    public int compare(Ticket o1, Ticket o2) {
        int durationTicket1 = calculateDurationTime(o1);
        int durationTicket2 = calculateDurationTime(o2);

        if (durationTicket2 > durationTicket1)
            return -1;

        if (durationTicket2 < durationTicket1)
            return 1;

        return 0;
    }
}
