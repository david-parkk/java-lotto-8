package lotto;

import java.util.List;

public class Lotto {
    private final String ERROR_LOG = "[ERROR] ";
    private final String INVALID_LOTTO_LENGTH = "로또 번호는 6개여야 합니다.";
    private final String DUPLICATE_LOTTO_NUMBER = "로또 번호는 중복값이 허용되지 않습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ERROR_LOG + INVALID_LOTTO_LENGTH);
            throw new IllegalArgumentException(ERROR_LOG + INVALID_LOTTO_LENGTH);
        }
        int count = (int) numbers.stream()
                .distinct()
                .count();
        if (count != numbers.size()) {
            System.out.println(ERROR_LOG + DUPLICATE_LOTTO_NUMBER);
            throw new IllegalArgumentException(ERROR_LOG + DUPLICATE_LOTTO_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
