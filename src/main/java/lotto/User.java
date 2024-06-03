package lotto;

import lotto.lotto.LottoRank;
import lotto.ticket.Ticket;
import lotto.ticket.TicketMachine;

import java.util.*;


public class User {

    private final int purchaseAmount;

    private final List<Ticket> tickets;

    public User(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.tickets = TicketMachine.buyLottoTickets(purchaseAmount);
    }

    protected User(int purchaseAmount, List<Ticket> tickets) {
        this.purchaseAmount = purchaseAmount;
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void printTicketAmount() {
        System.out.println(tickets.size() + "개를 구매했습니다.");
    }

    public void printTickets() {
        for (Ticket ticket : tickets) {
            var ticketNumbers = ticket.getNumbers();
            System.out.println(Arrays.toString(ticketNumbers.toArray()));
        }
    }

    public void printResult() {
        var lottoRankCount = getLotteRankCount();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format("3개 일치 (5,000원) - %d개", lottoRankCount.getOrDefault(LottoRank.FIFTH, 0)));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", lottoRankCount.getOrDefault(LottoRank.FOURTH, 0)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", lottoRankCount.getOrDefault(LottoRank.THIRD, 0)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", lottoRankCount.getOrDefault(LottoRank.SECOND, 0)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", lottoRankCount.getOrDefault(LottoRank.FIRST, 0)));
    }

    public String getRate() {
        return String.format("%.1f", (double) getTotalAmount() / purchaseAmount * 100);
    }

    protected Map<LottoRank, Integer> getLotteRankCount() {
        HashMap<LottoRank, Integer> lottoRankCount = new HashMap<>();
        for (Ticket ticket : tickets) {
            lottoRankCount.compute(
                    ticket.getLottoRank(),
                    (key, value) -> Optional.ofNullable(value).orElse(0) + 1
            );
        }
        return lottoRankCount;
    }

    private int getTotalAmount() {
        return tickets.stream()
                .mapToInt(
                        value -> value.getLottoRank().getPriceAmount()
                ).sum();
    }
}
