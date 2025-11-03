package lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {

    private RandomCreator randomCreator;

    public LottoFactory(int startNumber, int endNumber) {
        this.randomCreator = new RandomCreator(startNumber, endNumber);
    }

    public Lotto createRandomLotto(int lottoLength) {
        List<Integer> numbers = randomCreator.createRandomNumbers(lottoLength);
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
}