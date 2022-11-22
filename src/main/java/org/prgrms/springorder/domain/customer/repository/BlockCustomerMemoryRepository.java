package org.prgrms.springorder.domain.customer.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.prgrms.springorder.domain.customer.model.BlockCustomer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("local")
public class BlockCustomerMemoryRepository implements BlockCustomerRepository {

    private final Map<UUID, BlockCustomer> storage = new ConcurrentHashMap<>();

    @Override
    public Optional<BlockCustomer> findById(UUID blockId) {
        return Optional.ofNullable(storage.get(blockId));
    }

    @Override
    public BlockCustomer insert(BlockCustomer blockCustomer) {

        storage.putIfAbsent(blockCustomer.getBlockId(), blockCustomer);
        return blockCustomer;
    }

    @Override
    public List<BlockCustomer> findAll() {
        return storage.values().stream().toList();
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }

}
