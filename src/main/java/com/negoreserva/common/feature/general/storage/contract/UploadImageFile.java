package com.negoreserva.common.feature.general.storage.contract;

import org.springframework.web.multipart.MultipartFile;

@FunctionalInterface
public interface UploadImageFile {
    String uploadImageFile(MultipartFile file, String folderName);
}
