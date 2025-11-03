package lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {
    private final String ERROR_LOG = "[ERROR] ";
    private final String DUPLICATE_BONUS_NUMBER = "보너스 번호는 로또 번호와 중복이 허용되지 않습니다.";

    private RandomCreator randomCreator;

    public LottoFactory(int startNumber, int endNumber) {
        this.randomCreator = new RandomCreator(startNumber, endNumber);
    }

    public Lotto createRandomLotto(int lottoLength) {
        List<Integer> numbers = randomCreator.createRandomNumbers(lottoLength);
        return new Lotto(numbers);
    }

    public Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Lotto> createRandomLottos(int lottoCount, int lottoLength) {
        return IntStream.rangeClosed(1, lottoCount)
                .mapToObj(i -> createRandomLotto(lottoLength))
                .toList();
    }

    public BonusLotto createRandomBonusLotto(Lotto lotto) {
        Integer randomNumber = randomCreator.createRandomNumber();

        while (true) {
            List<Integer> numbers = lotto.getNumbers();
            boolean isDuplicated = numbers.contains(randomNumber);
            if (isDuplicated) {
                randomNumber = randomCreator.createRandomNumber();
                continue;
            }
            return new BonusLotto(randomNumber);
        }
    }

    public BonusLotto createBonusLotto(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            System.out.println(ERROR_LOG + DUPLICATE_BONUS_NUMBER);
            throw new IllegalArgumentException(ERROR_LOG + DUPLICATE_BONUS_NUMBER);
        }
        return new BonusLotto(bonusNumber);
    }
}