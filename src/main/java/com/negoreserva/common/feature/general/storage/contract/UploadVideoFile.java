package com.negoreserva.common.feature.general.storage.contract;

import org.springframework.web.multipart.MultipartFile;

@FunctionalInterface
public interface UploadVideoFile {
    String uploadVideoFile(MultipartFile file, String folderName);
}
