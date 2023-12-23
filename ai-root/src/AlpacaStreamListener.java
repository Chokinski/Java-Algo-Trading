import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.model.endpoint.marketdata.common.realtime.MarketDataMessage;
import net.jacobpeterson.alpaca.model.endpoint.marketdata.common.realtime.enums.MarketDataMessageType;
import net.jacobpeterson.alpaca.model.endpoint.streaming.trade.TradeUpdate;
import net.jacobpeterson.alpaca.websocket.marketdata.MarketDataListener;

import java.util.Arrays;
import net.jacobpeterson.alpaca.websocket.marketdata.StreamError;


public class AlpacaStreamListener implements MarketDataListener{

    // Connect the websocket and confirm authentication

    private AlpacaAPI alpacaAPI = AlpacaController.connect(); // Add this line to declare the alpacaAPI object

    public AlpacaStreamListener(AlpacaAPI alpaca) {
    }

    public void connectAlpacaAPI() {
        alpacaAPI.stockMarketDataStreaming().connect();
        if (!alpacaAPI.stockMarketDataStreaming().isValid()) {
            ai.botLogger.error("Websocket not valid!");
            return;
        }

        // Listen to AAPL and TSLA trades and all bars via the wildcard operator ('*').
        alpacaAPI.stockMarketDataStreaming().subscribe(
                Arrays.asList("TSLA"),
                null,null);
    }

   @Override
    public void onStreamTrade(TradeUpdate tradeUpdate) {
        if ("TSLA".equals(tradeUpdate.getSymbol())) {
            ai.botLogger.info("TSLA Trade Update: {}", tradeUpdate);
        }
    }

    @Override
    public void onMessage(MarketDataMessageType messageType, MarketDataMessage message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onMessage'");
    }

    
    // ...

    @Override
    public void onStreamDisconnect() {
        ai.botLogger.info("Disconnected from Alpaca API");
    }
}
