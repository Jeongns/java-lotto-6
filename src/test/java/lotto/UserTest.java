package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoDrawMachine;
import lotto.lotto.LottoRank;
import lotto.ticket.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("당첨 결과를 Map형태로 취합한다")
    void validGetLottoCount() {
        // given
        User user = new User(
                3000,
                List.of(
                        new Ticket(List.of(1, 2, 3, 4, 5, 6)),
                        new Ticket(List.of(1, 2, 3, 4, 5, 6)),
                        new Ticket(List.of(1, 2, 3, 4, 5, 6))
                ));
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        // when
        lottoDrawMachine.compareTickets(user.getTickets());
        var lotteRankCount = user.getLotteRankCount();
        // then
        assertEquals(3, lotteRankCount.get(LottoRank.FIRST));
    }

}