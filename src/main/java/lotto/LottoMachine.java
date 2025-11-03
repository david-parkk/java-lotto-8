package lotto;

import java.util.List;

public class LottoMachine {

    private Lotto winningLotto;
    private BonusLotto bonusLotto;
    private WinningMachine winningMachine;

    public LottoMachine(Lotto winningLotto, BonusLotto bonusLotto, WinningMachine winningMachine) {
        this.winningLotto = winningLotto;
        this.winningMachine = winningMachine;
        this.bonusLotto = bonusLotto;
    }

    public WinningType checkWinning(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int sameCount = 0;
        boolean hasBonus = false;

        for (Integer number : numbers) {
            if (hasLottoNumber(number)) {
                sameCount++;
            }
            if (hasLottoNumber(number)) {
                hasBonus = true;
            }
        }
        return winningMachine.WinningMachine(sameCount, hasBonus);
    }

    private boolean hasLottoNumber(Integer inputNumber) {
        List<Integer> numbers = winningLotto.getNumbers();
        for (Integer number : numbers) {
            if (inputNumber.equals(number)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasBonusNumber(Integer inputNumber) {
        Integer number = bonusLotto.getNumber();
        if (number.equals(inputNumber)) {
            return true;
        }
        return false;
    }

}