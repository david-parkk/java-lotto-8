package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningFactory {

    public WinningFactory() {

    }

    public List<WinningType> createWinningTypes() {
        List<WinningType> winningTypes = new ArrayList<>();
        winningTypes.add(new WinningType(5, 3, 5000, false));
        winningTypes.add(new WinningType(4, 4, 50000, false));
        winningTypes.add(new WinningType(3, 5, 1500000, false));

        winningTypes.add(new WinningType(2, 5, 30000000, true));
        winningTypes.add(new WinningType(1, 6, 2000000000, false));
        return winningTypes;
    }
}