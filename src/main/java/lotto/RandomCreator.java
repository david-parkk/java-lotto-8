package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomCreator {

    private final int startRange;
    private final int endRange;

    public RandomCreator(final int startRange, final int endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public List<Integer> createRandomNumbers(int count) {
        return Randoms.pickUniqueNumbersInRange(startRange, endRange, count);
    }

    public Integer createRandomNumber() {
        return Randoms.pickNumberInRange(startRange, endRange);
    }
}