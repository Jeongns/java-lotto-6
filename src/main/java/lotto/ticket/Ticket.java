package lotto.ticket;

import java.util.List;

public class Ticket {

    private final List<Integer> numbers;

    public Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(Integer i) {
        return numbers.contains(i);
    }
}
