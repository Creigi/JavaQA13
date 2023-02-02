package ru.netology.tickets;

import java.util.Comparator;

public class TicketDurationComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTime() - o2.getTime();
    }
}
