package br.com.tech4music.tech4music.service;

import java.util.List;
import br.com.tech4music.tech4music.shared.MusicaDto;

public interface MusicaService {
    List<MusicaDto> obterTodas();
    MusicaDto obterPorId(String id);
    MusicaDto cadastrar(MusicaDto dto);
    MusicaDto atualizar(String id, MusicaDto dto);
    void remover(String id);
}
