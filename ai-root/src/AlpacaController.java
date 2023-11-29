package src;

import java.util.List;
import java.lang.Object;
import net.jacobpeterson.alpaca.rest.AlpacaClientException;
import net.jacobpeterson.alpaca.rest.endpoint.AlpacaEndpoint;
import net.jacobpeterson.alpaca.rest.endpoint.assets.AssetsEndpoint;
import net.jacobpeterson.alpaca.model.endpoint.assets.Asset;
import net.jacobpeterson.alpaca.rest.endpoint.assets.AssetStatus;
import net.jacobpeterson.alpaca.AlpacaAPI;

import net.jacobpeterson.alpaca.model.endpoint.assets.enums.AssetStatus;


public class AlpacaController {

    public static void main(String[] args) {
        // This constructor uses the 'alpaca.properties' file on the classpath for configuration
        AlpacaAPI alpacaAPI = new AlpacaAPI();

        // Use AlpacaAPI for further operations...
        List<String> assets = alpacaApi.AssetsEndpoint().getName();
        System.out.println("Assets: " + assets);
    }

    public List<Asset> get(AssetStatus assetStatus){}
}


