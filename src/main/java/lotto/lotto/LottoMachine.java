package lotto.lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    public static final int TICKET_PRICE = 1000;

    public static List<Lotto> buyLottoTickets(int money) {
        if (money % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.");
        }

        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < money; i += TICKET_PRICE) {
            lottoTickets.add(makeLottoTicket());
        }

        return lottoTickets;
    }

    private static Lotto makeLottoTicket() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
