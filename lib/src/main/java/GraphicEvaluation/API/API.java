package GraphicEvaluation.API;

import GraphicEvaluation.API.GoogleAPI.DetectTextGoogleAPI;
import GraphicEvaluation.Exceptions.ApiNotFoundException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;


public abstract class API {
    /**
     * Extract the information from an image
     *
     * @param filePath the path to the image
     */
    public abstract Map<String, String> detectText(String filePath) throws IOException;

    /**
     * This method decides which API to use
     *
     * @param nameApi The name of the API I want to use
     * @throws ApiNotFoundException if the name does not correspond to any API
     * @return  returns the API object mentioned by nameApi
     */
    public static API getApi(String nameApi) throws ApiNotFoundException {

        switch (nameApi) {
            case "google":
                return new DetectTextGoogleAPI();
            default:
                throw new ApiNotFoundException("Api not found");
        }
    }
}
