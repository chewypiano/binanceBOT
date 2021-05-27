package Analytics;

import Messaging.EventListener;
import Scheduling.ScheduleEvent;
import Source.OrderBook;

public class RiskWatcher implements EventListener {

    private double imbalance;

    /**
     * Creates a RiskWatcher.
     */
    public RiskWatcher() {
        this.imbalance = 0;
    }

    @Override
    public void handleEvent(OrderBook orderBook) throws InterruptedException {
        this.imbalance = OrderBookImbalance.computeOrderImbalance(orderBook);
    }

    @Override
    public void handleEvent(ScheduleEvent timer) throws InterruptedException {
        String tag = timer.getTag();
        if (!tag.equals("orderImbalance")) {
            return;
        }
        if (imbalance < 0) {
            System.out.println("Ask surplus, Imbalance : " + imbalance);
        } else {
            System.out.println("Bid surplus, Imbalance : " + imbalance);
        }
    }
}
