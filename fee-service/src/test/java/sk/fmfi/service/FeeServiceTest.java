package sk.fmfi.service;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import sk.fmfi.model.Fee;
import sk.fmfi.repository.FeeRepository;

import javax.inject.Inject;
import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class FeeServiceTest {

    @Inject
    private FeeService feeService;

    @InjectMock
    private FeeRepository feeRepository;

    @Test
    public void testCreateFeeSmallTranaction() {
        Fee fee = feeService.createFee("aaa-bbb", "4006064147", BigDecimal.TEN);

        assertNotNull(fee);
        assertThat(fee.getTransactionId(), is("aaa-bbb"));
        assertThat(fee.getAmount(), is(BigDecimal.valueOf(0.01)));
    }

    @Test
    public void testCreateFeeBigTranaction() {
        Fee fee = feeService.createFee("bbb-ccc", "4006064147", BigDecimal.valueOf(99999L));

        assertNotNull(fee);
        assertThat(fee.getTransactionId(), is("bbb-ccc"));
        assertThat(fee.getAmount(), is(BigDecimal.valueOf(2l)));
    }

}
