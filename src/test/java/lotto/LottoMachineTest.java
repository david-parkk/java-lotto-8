package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 로또_1등을_당첨될_수_있다() {
        LottoFactory lottoFactory = new LottoFactory(1, 7);
        Lotto lotto = lottoFactory.createRandomLotto(6);
        BonusLotto bonusLotto = lottoFactory.createRandomBonusLotto(lotto);

        WinningFactory winningFactory = new WinningFactory();
        List<WinningType> winningTypes = winningFactory.createWinningTypes();
        WinningMachine winningMachine = new WinningMachine(winningTypes);
        LottoMachine lottoMachine = new LottoMachine(lotto, bonusLotto, winningMachine);

        Lotto customLotto = lottoFactory.createRandomLotto(6);
        WinningType winningType = lottoMachine.checkWinning(customLotto);

        Assertions.assertThat(winningType.getRank() == 1);
    }
}
