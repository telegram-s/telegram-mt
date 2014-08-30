package org.telegram.mtproto;

import java.io.IOException;

/**
 * Exception while performing auth key generation
 */
public class ServerException extends IOException {
    public ServerException() {
    }

    public ServerException(String s) {
        super(s);
    }

    public ServerException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ServerException(Throwable throwable) {
        super(throwable);
    }
}
