package lotto;

import java.util.List;
import lotto.io.Input;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        LottoFactory lottoFactory = new LottoFactory(1, 60);

        int money = input.inputMoney();

        List<Integer> lottoNumbers = input.inputLottoNumber();
        Lotto lotto = lottoFactory.createLotto(lottoNumbers);

        int bonusNumber = input.inputBonusNumber();

        BonusLotto bonusLotto = lottoFactory.createBonusLotto(lotto, bonusNumber);

        WinningFactory winningFactory = new WinningFactory();
        List<WinningType> winningTypes = winningFactory.createWinningTypes();
        WinningMachine winningMachine = new WinningMachine(winningTypes);

        LottoMachine lottoMachine = new LottoMachine(lotto, bonusLotto, winningMachine);
    }
}
