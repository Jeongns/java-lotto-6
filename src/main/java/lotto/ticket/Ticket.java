package lotto.ticket;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Ticket {

    private final List<Integer> numbers;

    public Ticket() {
        //TODO 상수로 숫자 정의
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
