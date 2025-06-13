package br.com.tech4music.tech4music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4music.tech4music.model.Musica;
import br.com.tech4music.tech4music.repository.MusicaRepository;
import br.com.tech4music.tech4music.shared.MusicaDto;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository repo;

    private MusicaDto toDto(Musica m) {
        MusicaDto dto = new MusicaDto();
        dto.setId(m.getId());
        dto.setTitulo(m.getTitulo());
        dto.setArtista(m.getArtista());
        dto.setAlbum(m.getAlbum());
        dto.setGenero(m.getGenero());
        dto.setAnoLancamento(m.getAnoLancamento());
        dto.setCompositor(m.getCompositor());
        return dto;
    }

    private Musica toEntity(MusicaDto dto) {
        Musica m = new Musica();
        m.setId(dto.getId());
        m.setTitulo(dto.getTitulo());
        m.setArtista(dto.getArtista());
        m.setAlbum(dto.getAlbum());
        m.setGenero(dto.getGenero());
        m.setAnoLancamento(dto.getAnoLancamento());
        m.setCompositor(dto.getCompositor());
        return m;
    }

    @Override
    public List<MusicaDto> obterTodas() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public MusicaDto obterPorId(String id) {
        Optional<Musica> musica = repo.findById(id);
        return musica.map(this::toDto).orElse(null);
    }

    @Override
    public MusicaDto cadastrar(MusicaDto dto) {
        Musica musica = toEntity(dto);
        return toDto(repo.save(musica));
    }

    @Override
    public MusicaDto atualizar(String id, MusicaDto dto) {
        Musica m = toEntity(dto);
        m.setId(id);
        return toDto(repo.save(m));
    }

    @Override
    public void remover(String id) {
        repo.deleteById(id);
    }
}
