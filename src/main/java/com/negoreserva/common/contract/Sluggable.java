package com.negoreserva.common.contract;

public interface Sluggable extends  UniqueFieldSanitizer {
    void applySlug();
}
