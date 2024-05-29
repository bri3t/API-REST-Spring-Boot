package com.arnau_briet.gestionanimales.backend.presentation.restcontrollers;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.arnau_briet.gestionanimales.backend.business.model.Animal;
import com.arnau_briet.gestionanimales.backend.business.model.Caracteristicas;
import com.arnau_briet.gestionanimales.backend.business.services.AnimalServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = AnimalController.class)
public class AnimalControllerTest {

    private Animal animal1, animal2;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc miniPostman;

    @MockBean
    private AnimalServices animalServices;

    @BeforeEach
    void init() {
        initObjects();
    }

    private void initObjects() {
        Caracteristicas caracteristicas = new Caracteristicas();
        caracteristicas.setId(1l);
        caracteristicas.setHabitat("Granja");
        caracteristicas.setVidaMedia(20);


        animal1 = new Animal();
        animal1.setId(100L);
        animal1.setNombre("Cabra");
        animal1.setEspecie("Mamífero");
        animal1.setEstadoConservacion("Salvaje");
        animal1.setCaracteristicas(caracteristicas);

    

        animal2 = new Animal();
        animal2.setId(200L);
        animal2.setNombre("Vaca");
        animal2.setEspecie("Mamífero");
        animal2.setEstadoConservacion("Natural");
        animal2.setCaracteristicas(caracteristicas);
    }

    @Test
    void pedir_todos_los_animales() throws Exception {
        // Arrange

        List<Animal> animales = Arrays.asList(animal1, animal2);
        when(animalServices.getAll()).thenReturn(animales);

        // Act

        MvcResult respuesta = miniPostman.perform(get("/animales").contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = respuesta.getResponse().getContentAsString();

        String respuestaEsperada = objectMapper.writeValueAsString(animales);

        // Assert

        assertThat(responseBody).isEqualToIgnoringWhitespace(respuestaEsperada);
    }
}