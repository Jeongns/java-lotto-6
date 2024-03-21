package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class LottoMachineTest {

    @ParameterizedTest
    @ValueSource(ints = 1234)
    @DisplayName("옳바르지 않은 금액이 들어올 경우 에러를 발생 시킨다.")
    void validIncorrectAmountError(int money) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoMachine.buyLottoTickets(money));
    }

    @ParameterizedTest
    @ValueSource(ints = 5000)
    @DisplayName("로또를 정상적으로 구매하는지 확인한다.")
    void validBuyLottoTickets(int money) {
        //when
        List<Lotto> lottos = LottoMachine.buyLottoTickets(money);
        //then
        Assertions.assertEquals(lottos.size(), 5);
    }
}
