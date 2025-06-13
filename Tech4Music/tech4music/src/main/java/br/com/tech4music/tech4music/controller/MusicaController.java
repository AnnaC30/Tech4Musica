package br.com.tech4music.tech4music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.tech4music.tech4music.service.MusicaService;
import br.com.tech4music.tech4music.shared.MusicaDto;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {

    @Autowired
    private MusicaService service;

    @GetMapping
    public List<MusicaDto> obterTodas() {
        return service.obterTodas();
    }

    @GetMapping("/{id}")
    public MusicaDto obterPorId(@PathVariable String id) {
        return service.obterPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MusicaDto cadastrar(@RequestBody MusicaDto dto) {
        return service.cadastrar(dto);
    }

    @PutMapping("/{id}")
    public MusicaDto atualizar(@PathVariable String id, @RequestBody MusicaDto dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable String id) {
        service.remover(id);
    }
}

