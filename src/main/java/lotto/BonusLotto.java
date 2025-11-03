package lotto;

public class BonusLotto {
    private final String ERROR_LOG = "[ERROR] ";
    private final String INVALID_LOTTO_LENGTH = "보너스 번호는 1개여야 합니다.";

    private Integer number;

    public BonusLotto(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (number == null) {
            System.out.println(ERROR_LOG + INVALID_LOTTO_LENGTH);
            throw new IllegalArgumentException(ERROR_LOG + INVALID_LOTTO_LENGTH);
        }
    }
}
