package org.dataloader.impl;

import org.dataloader.DataLoader;
import org.dataloader.DataLoaderFactory;
import org.dataloader.DataLoaderRegistry;

import java.util.Map;
import java.util.function.Supplier;

public class SimpleDataLoaderFactory implements DataLoaderFactory {

    private final Map<String, Supplier<DataLoader<?, ?>>> suppliers;

    public SimpleDataLoaderFactory(Map<String, Supplier<DataLoader<?, ?>>> suppliers) {
        this.suppliers = suppliers;
    }

    @Override
    public DataLoader<?, ?> createForKey(String key) {
        Supplier<DataLoader<?, ?>> dataLoaderSupplier = suppliers.get(key);
        if (dataLoaderSupplier == null) {
            return null;
        }
        return dataLoaderSupplier.get();
    }

    public DataLoaderRegistry createRegistry() {
        DataLoaderRegistry registry = new DataLoaderRegistry();
        registry.useFactory(this);
        return registry;
    }
}
