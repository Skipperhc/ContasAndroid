package com.example.contasandroid.ui.service.utils

import java.lang.Exception
import java.lang.RuntimeException

class EmptyFieldsException(message: String) : RuntimeException(message)

class InsuficientValueException(message: String) : RuntimeException(message)