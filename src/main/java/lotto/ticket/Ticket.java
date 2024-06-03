package lotto.ticket;

import lotto.lotto.LottoRank;

import java.util.List;

public class Ticket {

    private final List<Integer> numbers;

    private LottoRank lottoRank;

    public Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setLottoRank(LottoRank lottoRank) {
        this.lottoRank = lottoRank;
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(Integer i) {
        return numbers.contains(i);
    }

}
