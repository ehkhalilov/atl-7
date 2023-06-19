package az.example.atl7.controller.rest;

import az.example.atl7.model.OrderDto;
import az.example.atl7.service.SagaService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saga")
public class SagaController {

    private final SagaService sagaService;

    public SagaController(SagaService sagaService) {
        this.sagaService = sagaService;
    }

    @PostMapping("/start")
    public Long startSaga(@RequestBody OrderDto orderDto) {
        return sagaService.startSaga(orderDto);
    }

    @PostMapping("/{sagaId}/complete-step-1")
    public void completeStep1(@PathVariable Long sagaId) {
        sagaService.completeStep1(sagaId);
    }

    @PostMapping("/{sagaId}/complete-step-2")
    public void completeStep2(@PathVariable Long sagaId) {
        sagaService.completeStep2(sagaId);
    }

    @PostMapping("/{sagaId}/complete-step-3")
    public void completeStep3(@PathVariable Long sagaId) {
        sagaService.completeStep3(sagaId);
    }

    @PostMapping("/{sagaId}/cancel-steps")
    public void cancelSteps(@PathVariable Long sagaId) {
        sagaService.cancelSteps(sagaId);
    }
}
