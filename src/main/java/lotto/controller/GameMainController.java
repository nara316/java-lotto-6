package lotto.controller;

import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameMainController {

    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;

    public GameMainController(GameService gameService, InputView inputView, OutputView outputView) {
        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            startGame();
            playGame();
            stopGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void startGame() {
        String purchaseAmount = inputView.inputPurchaseAmount();
        gameService.createPurchaseAmount(purchaseAmount);
        gameService.createLotteries();
        outputView.printPurchaseAmount(gameService.printPurchaseAmount());
        outputView.printLottoNumbers(gameService.printLottoNumbers());
    }

    private void playGame() {
        String winningNumber = inputView.inputWinningNumber();
        String bonusNumber = inputView.inputBonusNumber();
        gameService.createWinningLotto(winningNumber, bonusNumber);
        gameService.createLottoResult();
    }

    private void stopGame() {
        outputView.printGameResult(gameService.printGameResult());
        outputView.printEarningRate(gameService.printEarningRate());
    }
}
