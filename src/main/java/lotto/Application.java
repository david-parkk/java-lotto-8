package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory(1, 60, 6);
        Lotto lotto = lottoFactory.createRandomLotto();
        BonusLotto bonusLotto = lottoFactory.createRandomBonusLotto(lotto);

        WinningFactory winningFactory = new WinningFactory();
        List<WinningType> winningTypes = winningFactory.createWinningTypes();
        WinningMachine winningMachine = new WinningMachine(winningTypes);

        LottoMachine lottoMachine = new LottoMachine(lotto, bonusLotto, winningMachine);
    }
}
