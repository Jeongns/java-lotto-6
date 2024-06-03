package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoDrawMachine;

import static lotto.console.Read.*;

public class Application {
    public static void main(String[] args) {


        System.out.println("구입금액을 입력해 주세요.");
        User user = new User(ReadAmount());

        user.printTicketAmount();
        user.printTickets();

        System.out.println("당첨 번호를 입력해 주세요.");
        var lottoNumbers = ReadLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(lotto,  ReadLottoNumber());

        lottoDrawMachine.compareTickets(user.getTickets());

        user.printResult();

        System.out.println(String.format("총 수익률은 %s%%입니다.", user.getRate()));

    }
}
