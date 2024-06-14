package lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketMachineTest {

    @Test
    @DisplayName("로또 티켓을 구매한다.")
    void buyLottoTickets() {
        // given
        int money = 10000;
        // when
        var tickets = TicketMachine.buyLottoTickets(money);
        // then
        assertEquals(10, tickets.size());
    }
}