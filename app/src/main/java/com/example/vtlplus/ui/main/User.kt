package com.example.vtlplus.ui.main

import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("id")
    var id: Int = 0
    @SerializedName("name")
    var name: String? = null
    @SerializedName("rego")
    var rego: String? = null
}