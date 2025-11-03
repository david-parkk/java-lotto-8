package lotto;

import java.util.List;

public class WinningMachine {

    private List<WinningType> winningTypes;

    public WinningMachine(List<WinningType> winningTypes) {
        this.winningTypes = winningTypes;
    }

    public WinningType WinningMachine(int sameCount, boolean hasBonus) {
        for (WinningType winningType : winningTypes) {
            if (winningType.getSameCount() == sameCount && winningType.hasBonus() == hasBonus) {
                return winningType;
            }
        }
        return null;
    }
}
