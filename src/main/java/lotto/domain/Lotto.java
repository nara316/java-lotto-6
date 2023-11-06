package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import lotto.constant.ExceptionConstant;
import lotto.constant.NumberConstant;

public class Lotto implements Comparable<Lotto> {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateNumberSize(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ExceptionConstant.LOTTO_NUMBER_DUPliCATE.getMessage());
        }
    }

    private void validateNumberSize(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < NumberConstant.LOTTO_MIN_NUMBER.getNumber()
                    || NumberConstant.LOTTO_MAX_NUMBER.getNumber() < number) {
                throw new IllegalArgumentException(ExceptionConstant.LOTTO_NUMBER_SIZE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isCompareByBonusNumber(int bonusNumber) {
        for(Integer integer : numbers) {
            if (integer == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(number -> otherLotto.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
    }
}
