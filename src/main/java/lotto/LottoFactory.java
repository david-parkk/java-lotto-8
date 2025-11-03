package lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {

    private RandomCreator randomCreator;

    public LottoFactory(int startNumber, int endNumber, int lottoLength) {
        this.randomCreator = new RandomCreator(startNumber, endNumber, lottoLength);
    }

    public Lotto createRandomLotto() {
        List<Integer> numbers = randomCreator.createRandomNumbers();
        return new Lotto(numbers);
    }

    public List<Lotto> createRandomLottos(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> createRandomLotto())
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