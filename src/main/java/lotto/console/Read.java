package lotto.console;

import lotto.Error;
import lotto.ticket.TicketMachine;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Read {

    public static int ReadNumber() {
        try {
            return Integer.parseInt(readLine());
        } catch (IllegalArgumentException e) {
            Error.assertThrows(IllegalArgumentException.class, "숫자를 입력해주세요.");
            return ReadNumber();
        }
    }

    public static int ReadAmount() {
        int amount = ReadNumber();
        if (amount % TicketMachine.TICKET_PRICE != 0) {
            Error.assertThrows(IllegalArgumentException.class, String.format("구입 금액은 %,d원 단위로 입력해주세요.", TicketMachine.TICKET_PRICE));
            return ReadAmount();
        }
        return amount;
    }

    public static int ReadLottoNumber() {
        int number = ReadNumber();
        if (lottoValidator(number)) {
            Error.assertThrows(IllegalArgumentException.class, "로또 번호는 1부터 45까지의 숫자여야 합니다.");
            return ReadLottoNumber();
        }
        return number;
    }

    public static List<Integer> ReadLottoNumbers() {
        String numbers = readLine();
        String[] split = numbers.split(",");
        if (split.length != 6) {
            Error.assertThrows(IllegalArgumentException.class, "로또 번호는 6개의 숫자로 이루어져야 합니다.");
            return ReadLottoNumbers();
        }

        for(String number : split) {
            if (lottoValidator(Integer.parseInt(number))) {
                Error.assertThrows(IllegalArgumentException.class, "로또 번호는 1부터 45까지의 숫자여야 합니다.");
                return ReadLottoNumbers();
            }
        }

        return Arrays.stream(split).map(Integer::parseInt).toList();
    }

    private static boolean lottoValidator(int number) {
        return number < 1 || number > 45;
    }
}
