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
        Ticket firstTicket = new Ticket(List.of(1, 2, 3, 4, 5, 6));
        Ticket secondTicket = new Ticket(List.of(1, 2, 3, 4, 5, 7));
        Ticket thirdTicket = new Ticket(List.of(1, 2, 3, 4, 5, 8));
        Ticket fourthTicket = new Ticket(List.of(1, 2, 3, 4, 8, 9));
        Ticket fifthTicket = new Ticket(List.of(1, 2, 3, 8, 9, 10));
        Ticket nullTicket = new Ticket(List.of(1, 2, 8, 9, 10, 11));

        // then, when
        Assertions.assertAll(
                () -> assertEquals(LottoRank.FIRST, lottoDrawMachine.compareTicket(firstTicket)),
                () -> assertEquals(LottoRank.SECOND, lottoDrawMachine.compareTicket(secondTicket)),
                () -> assertEquals(LottoRank.THIRD, lottoDrawMachine.compareTicket(thirdTicket)),
                () -> assertEquals(LottoRank.FOURTH, lottoDrawMachine.compareTicket(fourthTicket)),
                () -> assertEquals(LottoRank.FIFTH, lottoDrawMachine.compareTicket(fifthTicket)),
                () -> assertNull(lottoDrawMachine.compareTicket(nullTicket))
        );
    }

}