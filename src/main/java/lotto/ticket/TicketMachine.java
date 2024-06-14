package lotto.ticket;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Error;

import java.util.ArrayList;
import java.util.List;

public class TicketMachine {

    public static final int TICKET_PRICE = 1000;

    public static List<Ticket> buyLottoTickets(int money) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < money; i += TICKET_PRICE) {
            tickets.add(new Ticket(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return tickets;
    }
}
