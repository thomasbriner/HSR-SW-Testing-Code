package ch.hsr.testing.unittest.mocking;

import ch.hsr.testing.unittest.testbuilderpattern.Address;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressRetrieverTestBadExample {

    private AddressRetriever addressRetriever;

    @Test
    public void testUsingRealOnlineHttpService() throws AddressRetrieverException {
        addressRetriever = new AddressRetriever("tQi0L08sltt5ZNwpdTW74AXlzn8nM51C");
        Address address = addressRetriever.retrieveAddress(600968.625,197426.921875);

        Assertions.assertThat(address.getCity()).isEqualTo("Wabern");
    }

}
