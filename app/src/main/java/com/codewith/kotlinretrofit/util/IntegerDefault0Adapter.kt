package com.codewith.kotlinretrofit.util

import com.google.gson.*
import java.lang.reflect.Type

class IntegerDefault0Adapter : JsonSerializer<Int>, JsonDeserializer<Int> {

    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Int? {
        try {
            if (json.asString == "" || json.asString == "null") {// Defined as int type , If the background returns "" perhaps null, Then return 0
                return 0
            }
        } catch (ignore: Exception) {
        }

        try {
            return json.asInt
        } catch (e: NumberFormatException) {
            throw JsonSyntaxException(e)
        }

    }


    override fun serialize(
        src: Int?,
        typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonElement {
        return JsonPrimitive(src!!)
    }
}