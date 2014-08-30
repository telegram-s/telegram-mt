package org.telegram.mtproto;

import org.telegram.tl.TLMethod;
import org.telegram.tl.TLObject;

/**
 * Wrapper for all rpc-requests
 */
public interface CallWrapper {
    public TLObject wrapObject(TLMethod srcRequest);
}
