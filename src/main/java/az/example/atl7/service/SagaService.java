package az.example.atl7.service;

import az.example.atl7.dao.SagaEntity;
import az.example.atl7.dao.SagaRepository;
import az.example.atl7.model.OrderDto;
import az.example.atl7.model.Step;
import org.springframework.stereotype.Service;

@Service
public class SagaService {
    private final SagaRepository sagaRepository;

    public SagaService(SagaRepository sagaRepository) {
        this.sagaRepository = sagaRepository;
    }

    public Long startSaga(OrderDto orderDto) {
        var saga = sagaRepository.save(
                new SagaEntity(null, orderDto.getId(), Step.STEP1)
        );

        return saga.getId();
    }

    public void completeStep1(Long sagaId) {
        //  create order
        var saga = sagaRepository.findById(sagaId).orElse(null);
        if (saga != null && saga.getStep() == Step.STEP1) {
            saga.setStep(Step.STEP2);
            sagaRepository.save(saga);
        }
    }

    public void completeStep2(Long sagaId) {
        var saga = sagaRepository.findById(sagaId).orElse(null);
        if (saga != null && saga.getStep() == Step.STEP2) {
            saga.setStep(Step.STEP3);
            sagaRepository.save(saga);
        }
        // create pay
    }

    public void completeStep3(Long sagaId) {
        // send sms
        var saga = sagaRepository.findById(sagaId).orElse(null);
        if (saga != null && saga.getStep() == Step.STEP3) {
            saga.setStep(Step.COMPLETE);
            sagaRepository.save(saga);
        }
    }

    public void cancelSteps(Long sagaId) {
        // if step == STEP2
        // rollback createOrder
        // else if step == STEP3
        // rollback createPay and createOrder
        var saga = sagaRepository.findById(sagaId).orElse(null);
        if (saga != null) {
            switch (saga.getStep()) {
                case STEP1 -> saga.setStep(Step.CANCEL);
                case STEP2 -> saga.setStep(Step.CANCEL);
                case STEP3 -> saga.setStep(Step.CANCEL);
            }

            sagaRepository.save(saga);
        }
    }

}
