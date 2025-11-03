package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomCreatorTest {

    @Test
    void 랜덤_숫자를_생성한다() {
        RandomCreator randomCreator = new RandomCreator(1, 10, 1);
        Integer randomNumber = randomCreator.createRandomNumber();

        Assertions.assertThat(randomNumber >= 1 && randomNumber <= 10);
    }
}
