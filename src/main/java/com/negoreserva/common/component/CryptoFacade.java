package com.negoreserva.common.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class CryptoFacade {

    private final AesBytesEncryptor encryptor;

    public CryptoFacade(
            @Value("${crypto.secret-key}") String secretKey,
            @Value("${crypto.salt}") String salt
    ) {
        this.encryptor = new AesBytesEncryptor(
                secretKey,
                salt,
                AesBytesEncryptor.CipherAlgorithm.GCM.defaultIvGenerator()
        );
    }

    public String encrypt(String plainText) {
        byte[] encrypted = encryptor.encrypt(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String encryptedBase64) {
        byte[] decrypted = encryptor.decrypt(Base64.getDecoder().decode(encryptedBase64));
        return new String(decrypted);
    }
}