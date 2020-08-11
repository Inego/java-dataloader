package org.dataloader;

import java.util.Map;
import java.util.function.Supplier;

public class LazyDataLoaderRegistry extends DataLoaderRegistry {

    private Map<String, Supplier<DataLoader<?, ?>>> suppliers;

    public LazyDataLoaderRegistry(Map<String, Supplier<DataLoader<?, ?>>> suppliers) {
        this.suppliers = suppliers;
    }

    @Override
    public <K, V> DataLoader<K, V> getDataLoader(String key) {
        return super.computeIfAbsent(key, (k) -> suppliers.get(k).get());
    }
}
