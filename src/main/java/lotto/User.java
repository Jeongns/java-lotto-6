package lotto;

import lotto.ticket.Ticket;
import lotto.ticket.TicketMachine;

import java.util.List;

public class User {

    private final int purchaseAmount;

    private final List<Ticket> tickets;

    public User(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.tickets = TicketMachine.buyLottoTickets(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
