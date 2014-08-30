package org.telegram.mtproto;

import java.io.IOException;

/**
 * Exception for transport security breaks
 */
public class TransportSecurityException extends IOException {
    public TransportSecurityException() {
    }

    public TransportSecurityException(String s) {
        super(s);
    }

    public TransportSecurityException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public TransportSecurityException(Throwable throwable) {
        super(throwable);
    }
}
