package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory(1, 60, 6);
        WinningFactory winningFactory = new WinningFactory();
        List<WinningType> winningTypes = winningFactory.createWinningTypes();
    }
}
