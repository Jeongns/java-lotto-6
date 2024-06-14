package lotto.lotto;

public enum LottoRank {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NOTHING(0);

    private int priceAmount;

    LottoRank(int priceAmount) {
        this.priceAmount = priceAmount;
    }

    public int getPriceAmount() {
        return priceAmount;
    }
}
