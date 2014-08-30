package org.telegram.mtproto;

/**
 * MTProto callback
 */
public interface MTProtoCallback {
    /**
     * Called when new mtproto session created
     *
     * @param proto current proto
     */
    public void onSessionCreated(MTProto proto);

    /**
     * Called when auth was invalidated
     *
     * @param proto current proto
     */
    public void onAuthInvalidated(MTProto proto);

    /**
     * On new API Message
     *
     * @param message raw message
     * @param proto   current proto
     */
    public void onApiMessage(byte[] message, MTProto proto);

    /**
     * On new RPC Result
     *
     * @param callId   request id
     * @param response raw response
     * @param proto    current proto
     */
    public void onRpcResult(int callId, byte[] response, MTProto proto);

    /**
     * On new RPCError
     *
     * @param callId    request id
     * @param errorCode error code
     * @param message   error message
     * @param proto     current proto
     */
    public void onRpcError(int callId, int errorCode, String message, MTProto proto);

    /**
     * On request confirmed
     *
     * @param callId request id
     */
    public void onConfirmed(int callId, MTProto proto);
}
