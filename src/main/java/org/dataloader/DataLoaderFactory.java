package org.dataloader;

public interface DataLoaderFactory {
    DataLoader<?, ?> createForKey(String key);
}
