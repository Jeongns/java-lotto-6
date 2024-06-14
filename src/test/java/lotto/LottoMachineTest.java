package lotto;

import lotto.ticket.Ticket;
import lotto.ticket.TicketMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class LottoMachineTest {
    @ParameterizedTest
    @ValueSource(ints = 5000)
    @DisplayName("로또를 정상적으로 구매하는지 확인한다.")
    void validBuyLottoTickets(int money) {
        //when
        List<Ticket> lottos = TicketMachine.buyLottoTickets(money);
        //then
        Assertions.assertEquals(lottos.size(), 5);
    }
}
