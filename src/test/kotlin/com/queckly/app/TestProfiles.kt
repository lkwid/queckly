package com.queckly.app

sealed class TestProfiles {
    companion object {
        const val UNIT = "Unit"
        const val INTEGRATION = "Integration"
    }
}
