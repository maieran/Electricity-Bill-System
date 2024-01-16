package Electricity.Cryptography;

import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AesCryptographyTest {


    @Test
    void inputPassword_whenEncryptAndDecrypt_thenSuccess() throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        //given
        String expectedTextAsResult = "success";
        String password = "password";
        IvParameterSpec iv = KeyGenerator.generateIv();
        SecretKey key = KeyGenerator.getKeyFromPassword(expectedTextAsResult);

        //when
        String encryptedPassword = AesCryptography.encrypt(expectedTextAsResult, key, iv);
        String decryptedPassword = AesCryptography.decrypt(encryptedPassword, key, iv);

        //then
        assertEquals(expectedTextAsResult, decryptedPassword);
    }

}