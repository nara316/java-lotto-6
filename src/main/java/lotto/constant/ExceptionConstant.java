package lotto.constant;

public enum ExceptionConstant {
    INPUT_IS_ESSENTIAL("입력값은 필수입니다."),
    INPUT_IS_NUMBER("입력값은 자연수의 숫자만을 허용합니다."),
    PURCHASE_MIN_NUMBER("구매 최소 금액은 %s원 입니다."),
    PURCHASE_REMAINDER("구매 금액은 %s원 단위로 가능합니다.");

    private final String message;

    ExceptionConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
