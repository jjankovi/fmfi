package sk.fmfi.service;

import lombok.extern.log4j.Log4j2;
import sk.fmfi.model.Fee;
import sk.fmfi.repository.FeeRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RequestScoped
@Log4j2
public class FeeServiceBean implements FeeService {

    private final FeeRepository feeRepository;

    @Inject
    public FeeServiceBean(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Fee createFee(String transactionId, String acno, BigDecimal transactionAmount) {
        log.info("Creating fee for transactionId={}, acno={}, transactionAmount={}", transactionId, acno, transactionAmount);

        Fee fee = new Fee();
        fee.setTransactionId(transactionId);
        fee.setAcno(acno);
        fee.setCreationDate(LocalDateTime.now());
        fee.setAmount(BigDecimal.valueOf(0.01));
        if (transactionAmount != null && transactionAmount.compareTo(BigDecimal.valueOf(10000l)) > 0) {
            fee.setAmount(BigDecimal.valueOf(2l));
        }
        feeRepository.persist(fee);

        return fee;
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<Fee> getAllFees() {
        return feeRepository.listAll();
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<Fee> getFeesForAcno(String acno) {
        return feeRepository.listForAcno(acno);
    }
}
