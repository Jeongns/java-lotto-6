package lotto.lotto;

import lotto.ticket.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LottoDrawMachineTest {

    @Test
    @DisplayName("당첨 로또 번호를 받아 발행한 로또와 비교해 결과를 저장한다.")
    void validCompareTicket() {
        // given
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );

        //list of
        List<Ticket> tickets = List.of(
                new Ticket(List.of(1, 2, 3, 4, 5, 6)),
                new Ticket(List.of(1, 2, 3, 4, 5, 7)),
                new Ticket(List.of(1, 2, 3, 4, 5, 8)),
                new Ticket(List.of(1, 2, 3, 4, 8, 9)),
                new Ticket(List.of(1, 2, 3, 8, 9, 10)),
                new Ticket(List.of(1, 2, 8, 9, 10, 11))
        );

        //when
        lottoDrawMachine.compareTickets(tickets);

        // then
        Assertions.assertAll(
                () -> assertEquals(LottoRank.FIRST, tickets.get(0).getLottoRank()),
                () -> assertEquals(LottoRank.SECOND, tickets.get(1).getLottoRank()),
                () -> assertEquals(LottoRank.THIRD, tickets.get(2).getLottoRank()),
                () -> assertEquals(LottoRank.FOURTH, tickets.get(3).getLottoRank()),
                () -> assertEquals(LottoRank.FIFTH, tickets.get(4).getLottoRank()),
                () -> assertEquals(LottoRank.NOTHING, tickets.get(5).getLottoRank())
        );
    }

}