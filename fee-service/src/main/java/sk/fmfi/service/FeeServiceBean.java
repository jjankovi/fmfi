package sk.fmfi.service;

import sk.fmfi.model.Fee;
import sk.fmfi.repository.FeeRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RequestScoped
public class FeeServiceBean implements FeeService {

    private final FeeRepository feeRepository;

    @Inject
    public FeeServiceBean(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    @Override
    public Fee createFee(String transactionId, String acno, BigDecimal transactionAmount) {
        Fee fee = new Fee();
        fee.setTransactionId(transactionId);
        fee.setAcno(acno);
        fee.setPostingDate(LocalDateTime.now());

        // TODO nejaka logika podla typu transakcie a vysky?
        fee.setAmount(BigDecimal.ZERO);

        feeRepository.persist(fee);

        return fee;
    }

    @Override
    public List<Fee> getAllFees() {
        return feeRepository.listAll();
    }

    @Override
    public List<Fee> getFeesForAcno(String acno) {
        return feeRepository.listForAcno(acno);
    }
}
