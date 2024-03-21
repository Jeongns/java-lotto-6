package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoMachine;

import java.util.List;

public class User {

    private final int purchaseAmount;

    private final List<Lotto> lottoTickets;

    public User(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottoTickets = LottoMachine.buyLottoTickets(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
