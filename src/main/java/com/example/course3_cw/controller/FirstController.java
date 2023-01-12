package com.example.course3_cw.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/")
    @Tag(name = "Запуск приложения")
    public String startApp() {
        return "Приложение запущено";
    }
    @GetMapping("/info")
    @Tag(name = "Информация",description = "Информация о приложении")
    public String info() {
        return "Имя: Роман,Название проекта: 'CW',Дата создания проекта: '12.01.2022',Описание проекта: 'Название: CW,Функции'Учет товаров',Пока не знаю,Java 17'";
    }
}
