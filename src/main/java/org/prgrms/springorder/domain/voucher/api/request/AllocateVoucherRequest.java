package org.prgrms.springorder.domain.voucher.api.request;

import java.util.UUID;
import org.prgrms.springorder.console.io.Request;
import org.prgrms.springorder.util.UUIDValidator;

public class AllocateVoucherRequest implements Request {

    private final UUID voucherId;

    private final UUID customerId;

    public AllocateVoucherRequest(String voucherId, String customerId) {
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
}
