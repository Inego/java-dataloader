package org.dataloader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LazyDataLoaderFactory {

    private final Map<String, Supplier<DataLoader<?, ?>>> suppliers;

    public LazyDataLoaderFactory(Map<String, Supplier<DataLoader<?, ?>>> suppliers) {
        this.suppliers = suppliers;
    }

    public LazyDataLoaderFactory() {
        this(new HashMap<>());
    }

    public void register(String key, Supplier<DataLoader<?, ?>> supplier) {
        suppliers.put(key, supplier);
    }

    public LazyDataLoaderRegistry createRegistry() {
        return new LazyDataLoaderRegistry(suppliers);
    }
}
