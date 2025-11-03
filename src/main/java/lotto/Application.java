package lotto;

import java.util.List;
import lotto.io.Input;
import lotto.io.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        LottoFactory lottoFactory = new LottoFactory(1, 60);

        int money = input.inputMoney();
        List<Lotto> lottos = lottoFactory.createRandomLottos(money / 1000, 6);
        output.outputLottos(lottos);

        List<Integer> lottoNumbers = input.inputLottoNumber();
        Lotto lotto = lottoFactory.createLotto(lottoNumbers);

        int bonusNumber = input.inputBonusNumber();

        BonusLotto bonusLotto = lottoFactory.createBonusLotto(lotto, bonusNumber);

        WinningFactory winningFactory = new WinningFactory();
        List<WinningType> winningTypes = winningFactory.createWinningTypes();
        WinningMachine winningMachine = new WinningMachine(winningTypes);

        LottoMachine lottoMachine = new LottoMachine(lotto, bonusLotto, winningMachine);

        WinningType winningTypeResult = lottoMachine.checkWinning(lotto);
        output.outputWinningResult(winningTypes, winningTypeResult);
    }
}
