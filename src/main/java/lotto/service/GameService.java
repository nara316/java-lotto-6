package lotto.service;

import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.util.RandomNumberGenerator;

public class GameService {

    private final RandomNumberGenerator randomNumberGenerator;

    private PurchaseAmount purchaseAmount;
    private WinningLotto winningLotto;
    private Lotteries lotteries;

    public GameService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void createPurchaseAmount(String userInput) {
        purchaseAmount = PurchaseAmount.from(userInput);
    }

    public void createWinningLotto(String winningNumber, String bonusNumber) {
        winningLotto = WinningLotto.of(winningNumber, bonusNumber);
    }

    public void createLotteries() {
        lotteries = Lotteries.from(purchaseAmount.calculateAmountOfLotteries());
    }

    public List<List<Integer>> printLottoNumbers() {
        return lotteries.getNumbersOfLotteries();
    }

    public int printPurchaseAmount() {
        return purchaseAmount.calculateAmountOfLotteries();
    }
}
