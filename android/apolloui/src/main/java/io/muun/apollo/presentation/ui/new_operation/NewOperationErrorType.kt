package io.muun.apollo.presentation.ui.new_operation

import io.muun.apollo.presentation.analytics.AnalyticsEvent.S_NEW_OP_ERROR_TYPE

enum class NewOperationErrorType {
    INVALID_ADDRESS,
    AMOUNT_TOO_SMALL,
    INSUFFICIENT_FUNDS,
    INVOICE_UNREACHABLE_NODE,
    INVOICE_NO_ROUTE,
    INVOICE_EXPIRED,
    INVOICE_WILL_EXPIRE_SOON,
    INVOICE_ALREADY_USED,
    INVOICE_MISSING_AMOUNT,
    INVALID_INVOICE,
    EXCHANGE_RATE_WINDOW_TOO_OLD,
    INVALID_SWAP,  // esoteric error. Swapper server response failed validation
    CYCLICAL_SWAP,
    GENERIC;

    fun toAnalyticsEvent(): S_NEW_OP_ERROR_TYPE =
        when (this) {
            AMOUNT_TOO_SMALL -> S_NEW_OP_ERROR_TYPE.AMOUNT_BELOW_DUST
            INSUFFICIENT_FUNDS -> S_NEW_OP_ERROR_TYPE.INSUFFICIENT_FUNDS
            INVOICE_NO_ROUTE -> S_NEW_OP_ERROR_TYPE.NO_PAYMENT_ROUTE
            INVOICE_EXPIRED -> S_NEW_OP_ERROR_TYPE.EXPIRED_INVOICE
            INVOICE_WILL_EXPIRE_SOON -> S_NEW_OP_ERROR_TYPE.INVOICE_EXPIRES_TOO_SOON
            INVOICE_ALREADY_USED -> S_NEW_OP_ERROR_TYPE.INVOICE_ALREADY_USED
            INVALID_INVOICE -> S_NEW_OP_ERROR_TYPE.INVALID_INVOICE
            INVOICE_MISSING_AMOUNT -> S_NEW_OP_ERROR_TYPE.INVOICE_MISSING_AMOUNT
            EXCHANGE_RATE_WINDOW_TOO_OLD -> S_NEW_OP_ERROR_TYPE.EXCHANGE_RATE_WINDOW_TOO_OLD
            INVALID_SWAP -> S_NEW_OP_ERROR_TYPE.INVALID_SWAP
            else -> S_NEW_OP_ERROR_TYPE.OTHER
        }
}