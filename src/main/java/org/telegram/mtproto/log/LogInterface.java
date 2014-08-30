package org.telegram.mtproto.log;

/**
 * Interface for custom logger
 */
public interface LogInterface {
    void w(String tag, String message);

    void d(String tag, String message);

    void e(String tag, Throwable t);
}
