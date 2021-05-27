package Analytics;

import Source.OrderBook;

import java.math.BigDecimal;

public class OrderBookImbalance {

    public static double computeOrderImbalance(OrderBook orderBook) {
        double bestAskVolume = orderBook.getBestAsk().getValue().doubleValue();
        double bestBidVolume = orderBook.getBestBid().getValue().doubleValue();

        return (bestBidVolume - bestAskVolume) / (bestBidVolume + bestAskVolume);
    }
}
