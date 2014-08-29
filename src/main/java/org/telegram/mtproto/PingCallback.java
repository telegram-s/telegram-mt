package org.telegram.mtproto;

/**
 * Created by ex3ndr on 29.08.14.
 */
public interface PingCallback {
    void onPingSuccess(long id);

    void onPingTimeout(long id);
}
