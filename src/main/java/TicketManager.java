public class TicketManager {

    private TicketRepository repository;

    public TicketManager(TicketRepository repository){
        this.repository = repository;
    }

    public void addTicket(Ticket ticket) {
        repository.addTicket(ticket);
    }

    public void removeTicketById(int id) {
        repository.removeTicketById(id);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result  = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().equals(from)) {
            if (ticket.getTo().equals(to)) {
                return true;
            }
        }
        return false;
    }
}
