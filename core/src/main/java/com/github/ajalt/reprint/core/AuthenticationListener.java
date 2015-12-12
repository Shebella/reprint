package com.github.ajalt.reprint.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * A listener that is notified of the results of fingerprint authentication.
 */
public interface AuthenticationListener {
    /**
     * Called after a fingerprint is successfully authenticated.
     */
    void onSuccess();

    /**
     * Called after an error or authentication failure.
     *
     * @param failureReason The general reason for the failure.
     * @param fatal         If true, the failure is unrecoverable and the sensor is no longer
     *                      running. If false, the sensor is still running, and one or more
     *                      callbacks will be called in the future.
     * @param errorMessage  If not null, an informative string given by the underlying fingerprint
     *                      sdk that can be displayed in the ui.
     * @param moduleTag    The {@link ReprintModule#tag()} of the module that is currently active.
     *                      This is useful to know the meaning of the error code.
     * @param errorCode     The specific error code returned by the module's underlying sdk. Check
     *                      the constants defined in the module for possible values and their
     *                      meanings.
     */
    void onFailure(@NonNull AuthenticationFailureReason failureReason,
                   boolean fatal, @Nullable CharSequence errorMessage,
                   int moduleTag, int errorCode);
}