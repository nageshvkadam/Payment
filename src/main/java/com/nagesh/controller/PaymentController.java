import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nagesh.PaymentApplication;
import com.payment.entity.Payment;
import com.payment.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class PaymentController {

    private final PaymentApplication paymentApplication;

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService, PaymentApplication paymentApplication) {
        this.paymentService = paymentService;
        this.paymentApplication = paymentApplication;
    }

    @PostMapping("/create")
    public String createPayment(@RequestBody Payment payment)
            throws Exception {

        return paymentService.createPayment(payment);
    }
}