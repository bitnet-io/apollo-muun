package io.muun.apollo.domain.errors

open class HardwareCapabilityError : MuunError {

    constructor() : super()

    constructor(cap: String, cause: Throwable) : super("Error reading hardware capability", cause) {
        metadata["capability"] = cap
    }
}
