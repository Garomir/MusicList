package com.ramich.MusicList;

import com.ramich.MusicList.controllers.MyController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //для автоматического создания структуры классов, которые подменяют слой MVC в нашем приложении
public class SomeTest {

    @Autowired
    private MyController myController;

    @Test // здесь мы проверяем что у нас контроллер из контекста успешно подтянут
    public void test() throws Exception{
        assertThat(myController).isNotNull();
    }
}
