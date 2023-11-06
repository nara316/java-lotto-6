package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.OutputConstant;
import lotto.constant.PriceConstant;

public class OutputView {

    public void printPurchaseAmount(int purchaseAmount) {
        System.out.printf(OutputConstant.PURCHASE_RESULT.getMessage(), purchaseAmount);
    }

    public void printLottoNumbers(List<List<Integer>> lotteriesNumber) {
        for (List<Integer> lottoNumbers : lotteriesNumber) {
            System.out.println(lottoNumbers);
        }
    }

    public void printGameResult(Map<String, Integer> lottoResult) {
        System.out.println(OutputConstant.WINNING_STATS.getMessage());

//        for (Map.Entry<String, Integer> result : lottoResult.entrySet()) {
//            System.out.printf(OutputConstant.WINNING_STATS_RESULT.getMessage(),
//                    result.getKey(), PriceConstant.getPricebyCount(result.getKey()), result.getValue());
//
//            if (result.getKey() == PriceConstant.SECOND_PLACE.getCount()) {
//                System.out.printf(OutputConstant.WINNING_STATS_BONUS_RESULT.getMessage(),
//                        result.getKey(), PriceConstant.getPricebyCount(result.getKey()), result.getValue());
//            }
//        }
    }

    public void printEarningRate(double printEarningRate) {
        System.out.printf(OutputConstant.TOTAL_EARNING_RATE.getMessage(), printEarningRate);
    }
}
