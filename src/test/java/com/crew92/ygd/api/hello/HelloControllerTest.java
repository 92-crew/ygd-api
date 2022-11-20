package com.crew92.ygd.api.hello;

import com.crew92.ygd.api.RestDocumentation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("HelloController")
class HelloControllerTest extends RestDocumentation {

    @Test
    void hello() throws Exception {
        this.mockMvc.perform(get("/hello").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("hello"));
    }
}
