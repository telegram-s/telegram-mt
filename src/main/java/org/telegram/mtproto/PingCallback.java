package org.telegram.mtproto;

/**
 * Ping callback
 */
public interface PingCallback {
    void onPingSuccess(long id);

    void onPingTimeout(long id);
}
