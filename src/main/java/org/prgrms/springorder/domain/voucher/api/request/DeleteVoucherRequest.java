package org.prgrms.springorder.domain.voucher.api.request;

import java.util.UUID;
import org.prgrms.springorder.util.UUIDValidator;

public class DeleteVoucherRequest {

    private UUID voucherId;

    private UUID customerId;

    public DeleteVoucherRequest(String voucherId, String customerId) {
        UUIDValidator.validateString(voucherId);
        UUIDValidator.validateString(customerId);
        this.voucherId = UUID.fromString(voucherId);
        this.customerId = UUID.fromString(customerId);
    }

    public UUID getVoucherId() {
        return voucherId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "DeleteVoucherRequest{" +
            "voucherId=" + voucherId +
            ", customerId=" + customerId +
            '}';
    }
}
