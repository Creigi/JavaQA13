import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.manager.TicketManager;
import ru.netology.repositories.TicketRepository;
import ru.netology.tickets.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 1000, "DME", "LED", 20);
    Ticket ticket2 = new Ticket(5, 200, "DME", "KUF", 120);
    Ticket ticket3 = new Ticket(11, 1400, "KUF", "LED", 100);
    Ticket ticket4 = new Ticket(40, 2000, "DME", "KUF", 50);
    Ticket ticket5 = new Ticket(23, 1400, "LED", "MOW", 99);
    Ticket ticket6 = new Ticket(55, 500, "MOW", "KUF", 100);
    Ticket ticket7 = new Ticket(6, 100, "MOV", "LED", 54);
    Ticket ticket8 = new Ticket(3, 1650, "KUF", "LED", 102);
    Ticket ticket9 = new Ticket(63, 1000, "MOV", "LED", 100);
    Ticket ticket10 = new Ticket(80, 900, "MOV", "LED", 150);

    @Test
    public void sortTickets() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);
        manager.addTicket(ticket9);
        manager.addTicket(ticket10);

        Ticket[] expected = {ticket7, ticket2, ticket6, ticket10, ticket1, ticket9, ticket3, ticket5, ticket8, ticket4};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findFewMatches() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);
        manager.addTicket(ticket9);
        manager.addTicket(ticket10);


        Ticket[] expected = {ticket2, ticket4};
        Ticket[] actual = manager.findAll("DME", "KUF");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findFewMatchesWIthSort() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);
        manager.addTicket(ticket9);
        manager.addTicket(ticket10);


        Ticket[] expected = {ticket7, ticket10, ticket9};
        Ticket[] actual = manager.findAll("MOV", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findNoMatches() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);
        manager.addTicket(ticket9);
        manager.addTicket(ticket10);

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("DME", "kuf");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6); //id = 55
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);
        manager.addTicket(ticket9);
        manager.addTicket(ticket10);

        manager.removeTicketById(55);

        Ticket[] expected = {ticket7, ticket2, ticket10, ticket1, ticket9, ticket3, ticket5, ticket8, ticket4};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}