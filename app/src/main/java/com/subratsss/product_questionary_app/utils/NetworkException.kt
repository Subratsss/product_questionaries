package com.subratsss.product_questionary_app.utils

import java.io.IOException


class NetworkException : IOException() {
    override val message: String?
        get() = "No Internet Connection"
}