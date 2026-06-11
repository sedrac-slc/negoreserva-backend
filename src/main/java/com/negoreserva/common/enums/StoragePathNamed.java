package com.negoreserva.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public enum StoragePathNamed {
    USER_LOGO("user/%s/logo"),
    ORGANIZATION_IMAGE("organization/%s/image"),
    ORGANIZATION_VIDEO("organization/%s/video"),
    ORGANIZATION_LOGO("organization/%s/logo"),
    PRODUCT_IMAGE("product/%s/image"),
    PRODUCT_VIDEO("product/%s/video"),
    PAYMENT_RECEIPT("payment/%s/receipt");

    private final String path;

    public String suffix(UUID uuid) {
        return path.formatted(uuid);
    }
}
