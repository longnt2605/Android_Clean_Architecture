package com.namdinh.cleanarchitecture.api.helper.exceptions

sealed class Failure(cause: Throwable?) : Throwable(null, cause) {
    class NetworkConnection(cause: Throwable?) : Failure(cause)
    class ServerError(cause: Throwable?) : Failure(cause)
    class UnexpectedError(cause: Throwable?) : Failure(cause)

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureError(cause: Throwable?) : Failure(cause)
}