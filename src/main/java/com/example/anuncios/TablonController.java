package com.example.anuncios;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TablonController {

    private List<Anuncio> anuncios = new ArrayList<>();

    public TablonController() {
        //anuncios.add(new Anuncio("Pepe", "Hola caracola", "XXXX"));
        //anuncios.add(new Anuncio("Juan", "Hola caracola", "XXXX"));
    }

    @GetMapping("/")
    public String tablon(Model model) {

        model.addAttribute("anuncios", anuncios);

        return "tablon";
    }

    @PostMapping("/anuncio/nuevo")
    public String nuevoAnuncio(Model model, Anuncio anuncio) {

        anuncios.add(anuncio);
        return "anuncio_guardado";

    }

    @GetMapping("/anuncio/{num}")
    public String verAnuncio(Model model, @PathVariable String num) {
        Anuncio anuncio = null;
        try {
            int number = Integer.valueOf(num);
            if ((anuncios != null) && (anuncios.size() >= number) && (number > 0)) {
                anuncio = anuncios.get(number - 1);
            }
        } catch (NumberFormatException ex) {

        }
        model.addAttribute("anuncio", anuncio);
        return "ver_anuncio";
    }
}
