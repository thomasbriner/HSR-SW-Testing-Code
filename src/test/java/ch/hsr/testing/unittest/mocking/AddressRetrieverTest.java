package ch.hsr.testing.unittest.mocking;

import ch.hsr.testing.unittest.testbuilderpattern.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressRetrieverTest {

    private static final double DONT_CARE = 1.0;
    private static final String validAnswer = "{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"© 2023 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"© 2023 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":47.499916,\"lng\":8.723559}},\"locations\":[{\"street\":\"7 Bahnhofplatz\",\"adminArea6\":\"Winterthur\",\"adminArea6Type\":\"Neighborhood\",\"adminArea5\":\"Winterthur\",\"adminArea5Type\":\"City\",\"adminArea4\":\"Winterthur\",\"adminArea4Type\":\"County\",\"adminArea3\":\"ZH\",\"adminArea3Type\":\"State\",\"adminArea1\":\"CH\",\"adminArea1Type\":\"Country\",\"postalCode\":\"8400\",\"geocodeQualityCode\":\"L1AAA\",\"geocodeQuality\":\"ADDRESS\",\"dragPoint\":false,\"sideOfStreet\":\"L\",\"linkId\":\"0\",\"unknownInput\":\"\",\"type\":\"s\",\"latLng\":{\"lat\":47.49973,\"lng\":8.72393},\"displayLatLng\":{\"lat\":47.49979,\"lng\":8.72374},\"mapUrl\":\"\"}]}]}";
    private static final String invalidJson = "{no valid JSON}}}";
    private static final String unexpectedAnswer = "{\"foo\":\"bar\"}";
    public static final String SOME_API_KEY = "someApiKey";

    private AddressRetriever addressRetriever;


    @Test
    public void returnsAddressOnValidJSON() throws AddressRetrieverException, IOException {
        HttpService mock = mock(HttpService.class);
        when(mock.get(any())).thenReturn(validAnswer);

        addressRetriever = new AddressRetriever(SOME_API_KEY, mock);
        Address address = addressRetriever.retrieve(47.4999158, 8.7235591);

        Assertions.assertEquals("Winterthur", address.getCity());
    }

    @Test
    public void returnsExceptionOnInvalidJSON() throws AddressRetrieverException, IOException {
        HttpService mock = mock(HttpService.class);
        when(mock.get(any())).thenReturn(invalidJson);
        addressRetriever = new AddressRetriever(SOME_API_KEY, mock);
        Throwable t = null;

        try {
            addressRetriever.retrieve(DONT_CARE, DONT_CARE);
        } catch (AddressRetrieverException e) {
            t = e;
        }

        org.assertj.core.api.Assertions.assertThat(t).isNotNull();
        org.assertj.core.api.Assertions.assertThat(t.getLocalizedMessage()).contains("Could not parse");
    }


    @Test
    public void returnsExceptionOnUnexpectedAnswer() throws AddressRetrieverException, IOException {
        HttpService mock = mock(HttpService.class);
        when(mock.get(any())).thenReturn(unexpectedAnswer);
        addressRetriever = new AddressRetriever(SOME_API_KEY, mock);
        Throwable t = null;

        try {
            addressRetriever.retrieve(DONT_CARE, DONT_CARE);
        } catch (AddressRetrieverException e) {
            t = e;
        }

        org.assertj.core.api.Assertions.assertThat(t).isNotNull();
        org.assertj.core.api.Assertions.assertThat(t.getLocalizedMessage()).contains("Could not parse");
    }


    @Test
    public void returnsExceptionOnHttpException() throws AddressRetrieverException, IOException {
        HttpService mock = mock(HttpService.class);
        when(mock.get(any())).thenThrow(new IOException("just for fun"));
        addressRetriever = new AddressRetriever(SOME_API_KEY, mock);
        Throwable t = null;

        try {
            addressRetriever.retrieve(DONT_CARE, DONT_CARE);
        } catch (AddressRetrieverException e) {
            t = e;
        }

        org.assertj.core.api.Assertions.assertThat(t).isNotNull();
        org.assertj.core.api.Assertions.assertThat(t.getLocalizedMessage()).contains("Exception from HttpService");
    }


}
