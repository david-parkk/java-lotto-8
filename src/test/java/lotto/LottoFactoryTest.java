package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    @Test
    void 로또_번호를_생성_할_수_있다() {
        LottoFactory lottoFactory = new LottoFactory(4, 10, 6);
        Lotto lotto = lottoFactory.createRandomLotto();

        List<Integer> numbers = lotto.getNumbers();

        List<Integer> expected = List.of(4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(numbers.contains(expected));
    }

    @Test
    void 로또_번호와_다른_보너스_번호를_생성_해야_한다() {
        LottoFactory lottoFactory = new LottoFactory(4, 11, 6);
        Lotto lotto = lottoFactory.createRandomLotto();
        BonusLotto bonusLotto = lottoFactory.createRandomBonusLotto(lotto);

        List<Integer> numbers = lotto.getNumbers();
        Integer number = bonusLotto.getNumber();
        Assertions.assertThat(!numbers.contains(List.of(number)));
    }
}
