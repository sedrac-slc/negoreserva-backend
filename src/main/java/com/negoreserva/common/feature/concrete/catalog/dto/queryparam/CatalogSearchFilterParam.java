package com.negoreserva.common.feature.concrete.catalog.dto.queryparam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogSearchFilterParam {
    private String q;
    private List<UUID> organizationUuids;
}
