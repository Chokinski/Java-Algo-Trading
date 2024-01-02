package JAT;
import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.model.endpoint.marketdata.common.realtime.MarketDataMessage;
import net.jacobpeterson.alpaca.model.endpoint.marketdata.common.realtime.enums.MarketDataMessageType;
import net.jacobpeterson.alpaca.model.endpoint.streaming.trade.TradeUpdate;
import net.jacobpeterson.alpaca.websocket.marketdata.MarketDataListener;

import java.util.Arrays;
import net.jacobpeterson.alpaca.websocket.marketdata.MarketDataListener; // Add this import statement

public class AlpacaStreamListener implements MarketDataListener {

    // Connect the websocket and confirm authentication

    private AlpacaAPI alpacaAPI = AlpacaController.connect(); // Add this line to declare the alpacaAPI object

    public AlpacaStreamListener(AlpacaAPI alpaca) {
    }

    public void connectAlpacaAPI() {
        alpacaAPI.stockMarketDataStreaming().connect();
        if (!alpacaAPI.stockMarketDataStreaming().isValid()) {
            JATbot.botLogger.error("Websocket not valid!");
            return;
        }

        // Listen to AAPL and TSLA trades and all bars via the wildcard operator ('*').
        alpacaAPI.stockMarketDataStreaming().subscribe(
                Arrays.asList("TSLA"),
                null, null);
    }

    @Override
    public void onMessage(MarketDataMessageType messageType, MarketDataMessage message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onMessage'");
    }

    // Add a 'MarketDataListener' that simply prints market data information
    public class MyAlpacaStreamListener implements MarketDataListener {

        // ...
/* 
        @Override
        public void onStreamDisconnect() {
            ai.botLogger.info("Disconnected from Alpaca API");
        }
*/
        // Add the missing method implementation for 'onMessage'
        @Override
        public void onMessage(MarketDataMessageType messageType, MarketDataMessage message) {
            System.out.printf("%s: %s\n", messageType.name(), message);
        }
    }
}
