package org.telegram.mtproto.secure.aes;

import java.io.IOException;

/**
 * Interface fom implementation of AES encryption for mtproto
 */
public abstract interface AESImplementation {
    public void AES256IGEDecrypt(byte[] src, byte[] dest, int len, byte[] iv, byte[] key);

    public void AES256IGEEncrypt(byte[] src, byte[] dest, int len, byte[] iv, byte[] key);

    public void AES256IGEEncrypt(String sourceFile, String destFile, byte[] iv, byte[] key) throws IOException;

    public void AES256IGEDecrypt(String sourceFile, String destFile, byte[] iv, byte[] key) throws IOException;
}
