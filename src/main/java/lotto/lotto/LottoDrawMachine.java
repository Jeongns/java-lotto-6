package lotto.lotto;

import lotto.ticket.Ticket;

public class LottoDrawMachine {

    private Lotto lotto;
    private int bonusNumber;

    public LottoDrawMachine(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank compareTicket(Ticket ticket) {
        long duplicateTicketCount = countDuplicateTicket(ticket);

        if (duplicateTicketCount == 6)
            return LottoRank.FIRST;
        if (duplicateTicketCount == 5 && ticket.contains(bonusNumber))
            return LottoRank.SECOND;
        if (duplicateTicketCount == 5)
            return LottoRank.THIRD;
        if (duplicateTicketCount == 4)
            return LottoRank.FOURTH;
        if (duplicateTicketCount == 3)
            return LottoRank.FIFTH;

        return null;
    }

    private long countDuplicateTicket(Ticket ticket) {
        var lottoNumbers = lotto.getNumbers();
        return lottoNumbers.stream()
                .filter(i -> ticket.contains(i))
                .count();

    }
}
