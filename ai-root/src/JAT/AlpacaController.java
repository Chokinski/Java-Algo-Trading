package JAT;
import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.model.endpoint.account.Account;
import net.jacobpeterson.alpaca.model.endpoint.orders.Order;
import net.jacobpeterson.alpaca.model.endpoint.orders.enums.OrderSide;
import net.jacobpeterson.alpaca.rest.AlpacaClientException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import net.jacobpeterson.alpaca.model.endpoint.assets.Asset;
import net.jacobpeterson.alpaca.model.endpoint.assets.enums.AssetClass;
import net.jacobpeterson.alpaca.model.endpoint.assets.enums.AssetStatus;
import net.jacobpeterson.alpaca.model.endpoint.marketdata.common.historical.bar.enums.BarTimePeriod;
import net.jacobpeterson.alpaca.model.endpoint.marketdata.common.historical.trade.Trade;
import net.jacobpeterson.alpaca.model.endpoint.marketdata.stock.historical.bar.StockBarsResponse;
import net.jacobpeterson.alpaca.model.endpoint.marketdata.stock.historical.bar.enums.BarAdjustment;
import net.jacobpeterson.alpaca.model.endpoint.marketdata.stock.historical.bar.enums.BarFeed;
import net.jacobpeterson.alpaca.model.endpoint.marketdata.stock.historical.snapshot.Snapshot;
import net.jacobpeterson.alpaca.model.endpoint.marketdata.stock.historical.trade.StockTradesResponse;

public class AlpacaController {
    private static AlpacaAPI alpaca;
    private static AlpacaStreamListener alpacaStreamListener;

    /**
     * Connects to the Alpaca API using the properties specified in the
     * "alpaca.properties" file.
     * If the file or path is not found, a FileNotFoundException is thrown.
     * If an IO exception occurs while loading the properties, an IOException is
     * thrown.
     */
    public static AlpacaAPI connect() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("alpaca.properties"));
            String keyID = properties.getProperty("key_id");
            String secretKey = properties.getProperty("secret_key");
            alpaca = new AlpacaAPI(keyID, secretKey);
            return alpaca;

        } catch (FileNotFoundException exception) {
            JATbot.botLogger.error("Erorr, File/Path Not Found:" + exception.getMessage());
        } catch (IOException exception) {
            JATbot.botLogger.error("Erorr, IO Exception:" + exception.getMessage());
        }
        return null;

    }

    public static Account getAccount() {
        try {
            // Get 'Account' information
            Account account = alpaca.account().get();
            return account;
        } catch (AlpacaClientException exception) {
            JATbot.botLogger.error("Error getting acc info: " + exception.getMessage());
            return null;
        }

    }

    public static void logAccCash() {
        JATbot.botLogger.info("Account Cash: {}", AlpacaController.getAccount().getCash());
        System.out.println("Cash Logged" + "\n\n\n");
    }

    public static void logPortValue() {
        JATbot.botLogger.info("Portfolio Value: {}", AlpacaController.getAccount().getPortfolioValue());
        System.out.println("Portfolio Value Logged" + "\n\n\n");

    }

    public static void logStatus() {
        JATbot.botLogger.info("Account Status: {}", AlpacaController.getAccount().getStatus());
        System.out.println("Account Status Logged" + "\n\n\n");

    }

    public static void logCreateDate() {
        JATbot.botLogger.info("Date Created: {}", AlpacaController.getAccount().getCreatedAt());
        System.out.println("Date Created" + "\n\n\n");

    }

    public static Order placeTrade() {
        try {
            Order newOrder = alpaca.orders().requestMarketOrder(null, null, OrderSide.BUY, null);
            return newOrder;
        } catch (AlpacaClientException exception) {
            JATbot.botLogger.error("Error placing order: " + exception.getMessage());
        }
        return null;
    }

    public static void getAssets() {

        try {
            List<Asset> assets = alpaca.assets().get(AssetStatus.ACTIVE, AssetClass.US_EQUITY);
            JATbot.botLogger.info("Assets: {}", assets);
        } catch (AlpacaClientException exception) {
            JATbot.botLogger.error("Error getting assets: " + exception.getMessage());
        }
    }

    public static void logRecentData(String sym) {
        try {
            // Get 'sym' one hour, split-adjusted bars from 1/11/2023 market open
            // to 12/1/2023 market close from the SIP feed and print them out
            StockBarsResponse barsResponse = alpaca.stockMarketData().getBars(
                    sym,
                    ZonedDateTime.of(2023, 11, 1, 9, 30, 0, 0, ZoneId.of("America/New_York")),
                    ZonedDateTime.of(2023, 12, 1,12+4, 0, 0, 0, ZoneId.of("America/New_York")),
                    null,
                    null,
                    1,
                    BarTimePeriod.HOUR,
                    BarAdjustment.SPLIT,
                    BarFeed.SIP);
            barsResponse.getBars().forEach((bar) -> {
                String barString = bar.toString();
                int index = barString.indexOf("StockBar@");
                if (index != -1) {
                    String strippedBarString = barString.substring(index);
                    JATbot.botLogger.info(sym+" Bar: {}", strippedBarString);
                }
            });


        } catch (AlpacaClientException exception) {
            exception.printStackTrace();
        }
    }

    public static void startListeningForTSLATrades() {
        AlpacaAPI API = AlpacaController.connect();
        alpacaStreamListener = new AlpacaStreamListener(API);
        alpacaStreamListener.connectAlpacaAPI();
        
        
    }
}