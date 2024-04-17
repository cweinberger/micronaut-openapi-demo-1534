package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.openapi.annotation.OpenAPIGroup
import io.micronaut.serde.annotation.Serdeable

@Serdeable.Serializable
data class HelloResponseV1(val message: String)
@Serdeable.Serializable
data class HelloResponseV2(val message: String)

@Controller("/demo")
class DemoController {
    @OpenAPIGroup("v1", exclude = ["v2"])
    @Get
    fun indexV1(): HelloResponseV1 {
        return HelloResponseV1("Hello World V1")
    }

    @OpenAPIGroup("v2", exclude = ["v1"])
    @Get
    fun indexV2(): HelloResponseV2 {
        return HelloResponseV2("Hello World V2")
    }
}