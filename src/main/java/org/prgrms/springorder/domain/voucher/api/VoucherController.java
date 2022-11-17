package org.prgrms.springorder.domain.voucher.api;

import java.util.List;
import org.prgrms.springorder.console.io.ListResponse;
import org.prgrms.springorder.console.io.Response;
import org.prgrms.springorder.console.io.StringResponse;
import org.prgrms.springorder.domain.voucher.api.request.VoucherCreateRequest;
import org.prgrms.springorder.domain.voucher.model.Voucher;
import org.prgrms.springorder.domain.voucher.service.VoucherService;
import org.springframework.stereotype.Component;

@Component
public class VoucherController {

    private final VoucherService voucherService;

    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    public Response createVoucher(VoucherCreateRequest voucherCreateRequest) {
        Voucher voucher = voucherService.createVoucher(voucherCreateRequest);

        return new StringResponse(voucher);
    }

    public Response findAllVoucher() {
        List<Voucher> vouchers = voucherService.findAll();
        return new ListResponse(vouchers);
    }

    public Response findCustomerWithVoucher(VoucherIdRequest voucherIdRequest) {
        CustomerWithVoucher customerWithVoucher = voucherService.findVoucherWithCustomerByVoucherId(
            voucherIdRequest.getVoucherId());

        return new StringResponse(customerWithVoucher);
    }

}
