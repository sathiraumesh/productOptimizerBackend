package com.techass.prodcutpriceoptimizer;

import com.techass.prodcutpriceoptimizer.models.Product;
import com.techass.prodcutpriceoptimizer.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductService service;

    @Test
    public void getAllProductReturnMessage() throws Exception {
        this.mockMvc.perform(get("/api/product")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void calculatePrice() throws Exception {
        this.mockMvc.perform(post("/api/product/price")).andDo(print()).andExpect(status().isOk());
    }


}
