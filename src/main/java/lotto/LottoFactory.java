package lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {

    private RandomCreator randomCreator;

    public LottoFactory(int startNumber, int endNumber, int lottoLength) {
        this.randomCreator = new RandomCreator(startNumber, endNumber, lottoLength);
    }

    private Lotto createRandomLotto() {
        List<Integer> numbers = randomCreator.createRandomNumbers();
        return new Lotto(numbers);
    }

    public List<Lotto> createRandomLottos(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> createRandomLotto())
                .toList();
    }
}