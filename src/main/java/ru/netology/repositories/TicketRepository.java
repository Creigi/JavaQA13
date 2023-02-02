package ru.netology.repositories;

import ru.netology.tickets.Ticket;

import java.util.Arrays;

public class TicketRepository {

    Ticket[] tickets = new Ticket[0];

    public Ticket[] findAll() {
        Arrays.sort(tickets);
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeTicketById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }
}
