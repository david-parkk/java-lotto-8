package lotto.io;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import lotto.Lotto;
import lotto.WinningType;

public class Output {
    private NumberFormat numberFormat;

    public Output() {
        this.numberFormat = NumberFormat.getInstance(Locale.KOREA);
    }

    public void outputLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(this::outputLotto);
        System.out.println();
    }

    public void outputWinningResult(List<WinningType> winningTypes, WinningType winningTypeResult) {
        System.out.print("당첨 통계\n");
        System.out.print("---\n");
        winningTypes.stream()
                .forEach(winningType -> outputWinningResult(winningType, winningTypeResult));
    }

    public void outputWinningResult(WinningType winningType, WinningType winningTypeResult) {
        int count = 0;
        if (winningType.equals(winningTypeResult)) {
            count++;
        }
        if (winningType.hasBonus()) {

            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", winningType.getSameCount(),
                    numberFormat.format(winningType.getPrize()), count);
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n", winningType.getSameCount(),
                numberFormat.format(winningType.getPrize()), count);
    }

    public void outputSummary(double incomePercent) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMinimumFractionDigits(1);
        numberFormat.setMaximumFractionDigits(1);
        String formattedValue = numberFormat.format(incomePercent * 100) + "%";
        System.out.printf("총 수익률은 %s입니다.\n", formattedValue);
    }


    private void outputLotto(Lotto lotto) {
        System.out.printf("[%s]\n", lotto.toString());
    }
}