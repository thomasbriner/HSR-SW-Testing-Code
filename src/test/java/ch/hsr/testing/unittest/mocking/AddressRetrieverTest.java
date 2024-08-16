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
    private static final String validAnswer = "{\"results\": [{\"layerBodId\": \"ch.bfs.gebaeude_wohnungs_register\", \"layerName\": \"GWR: Geb\\u00e4udestatus\", \"featureId\": \"1272199_0\", \"id\": \"1272199_0\", \"attributes\": {\"egid\": \"1272199\", \"strname_deinr\": \"Seftigenstrasse 264\", \"plz_plz6\": \"3084/308400\", \"ggdename\": \"K\\u00f6niz\", \"ggdenr\": 355, \"gexpdat\": \"14.08.2024\", \"gdekt\": \"BE\", \"egrid\": \"CH669746359158\", \"lgbkr\": 0, \"lparz\": \"212\", \"lparzsx\": null, \"ltyp\": null, \"gebnr\": \"\", \"gbez\": \"\", \"gkode\": 2600983.546, \"gkodn\": 1197396.177, \"gksce\": 901, \"gstat\": 1004, \"gkat\": 1060, \"gklas\": null, \"gbauj\": null, \"gbaum\": null, \"gbaup\": 8011, \"gabbj\": null, \"garea\": 3143, \"gvol\": null, \"gvolnorm\": null, \"gvolsce\": null, \"gastw\": 4, \"ganzwhg\": null, \"gazzi\": null, \"gschutzr\": null, \"gebf\": null, \"gwaerzh1\": 7430, \"genh1\": 7542, \"gwaersceh1\": 865, \"gwaerdath1\": \"14.03.2023\", \"gwaerzh2\": null, \"genh2\": null, \"gwaersceh2\": null, \"gwaerdath2\": \"-\", \"gwaerzw1\": 7630, \"genw1\": 7530, \"gwaerscew1\": 869, \"gwaerdatw1\": \"29.11.2001\", \"gwaerzw2\": null, \"genw2\": null, \"gwaerscew2\": null, \"gwaerdatw2\": \"-\", \"edid\": \"0\", \"egaid\": 100718281, \"deinr\": \"264\", \"esid\": 10006665, \"strname\": [\"Seftigenstrasse\"], \"strnamk\": [\"Seftigenstr.\"], \"strindx\": [\"Sef\"], \"strsp\": [\"DE\"], \"stroffiziel\": \"1\", \"dplz4\": 3084, \"dplzz\": 0, \"dplzname\": \"Wabern\", \"dkode\": 2600968.668, \"dkodn\": 1197426.954, \"doffadr\": 1, \"dexpdat\": \"14.08.2024\", \"ewid\": null, \"whgnr\": null, \"wstwk\": null, \"wmehrg\": null, \"weinr\": null, \"wbez\": null, \"wstat\": null, \"wexpdat\": null, \"wbauj\": null, \"wabbj\": null, \"warea\": null, \"wazim\": null, \"wkche\": null, \"label\": \"Seftigenstrasse 264\"}}]}";
    private static final String invalidJson = "{no valid JSON}}}";
    private static final String unexpectedAnswer = "{\"foo\":\"bar\"}";
    public static final String SOME_API_KEY = "someApiKey";

    private AddressRetriever addressRetriever;


    @Test
    public void returnsAddressOnValidJSON() throws AddressRetrieverException, IOException {
        HttpService mock = mock(HttpService.class);
        when(mock.get(any())).thenReturn(validAnswer);

        addressRetriever = new AddressRetriever(SOME_API_KEY, mock);
        Address address = addressRetriever.retrieveAddress(600968.625,197426.921875);

        Assertions.assertEquals("Wabern", address.getCity());
    }

    @Test
    public void returnsExceptionOnInvalidJSON() throws IOException {
        HttpService mock = mock(HttpService.class);
        when(mock.get(any())).thenReturn(invalidJson);
        addressRetriever = new AddressRetriever(SOME_API_KEY, mock);
        Throwable t = null;

        try {
            addressRetriever.retrieveAddress(DONT_CARE, DONT_CARE);
        } catch (AddressRetrieverException e) {
            t = e;
        }

        org.assertj.core.api.Assertions.assertThat(t).isNotNull();
        org.assertj.core.api.Assertions.assertThat(t.getLocalizedMessage()).contains("Could not parse");
    }


    @Test
    public void returnsExceptionOnUnexpectedAnswer() throws IOException {
        HttpService mock = mock(HttpService.class);
        when(mock.get(any())).thenReturn(unexpectedAnswer);
        addressRetriever = new AddressRetriever(SOME_API_KEY, mock);
        Throwable t = null;

        try {
            addressRetriever.retrieveAddress(DONT_CARE, DONT_CARE);
        } catch (AddressRetrieverException e) {
            t = e;
        }

        org.assertj.core.api.Assertions.assertThat(t).isNotNull();
        org.assertj.core.api.Assertions.assertThat(t.getLocalizedMessage()).contains("Could not parse");
    }


    @Test
    public void returnsExceptionOnHttpException() throws IOException {
        HttpService mock = mock(HttpService.class);
        when(mock.get(any())).thenThrow(new IOException("just for fun"));
        addressRetriever = new AddressRetriever(SOME_API_KEY, mock);
        Throwable t = null;

        try {
            addressRetriever.retrieveAddress(DONT_CARE, DONT_CARE);
        } catch (AddressRetrieverException e) {
            t = e;
        }

        org.assertj.core.api.Assertions.assertThat(t).isNotNull();
        org.assertj.core.api.Assertions.assertThat(t.getLocalizedMessage()).contains("Exception from HttpService");
    }


}
