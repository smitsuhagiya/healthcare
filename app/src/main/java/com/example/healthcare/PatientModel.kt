package com.example.healthcare

import android.security.identity.AccessControlProfileId

data class PatientModel(
    var fullName: String? = null,
    var address: String? = null,
    var contactNumber: String? = null,
    var date: String? = null,

)