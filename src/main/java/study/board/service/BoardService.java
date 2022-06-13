package study.board.service;

import org.springframework.stereotype.Service;
import study.board.domain.entity.BoardEntity;
import study.board.domain.repository.BoardRepository;
import study.board.dto.BoardDto;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional
    public List<BoardDto> getBoardList() {
        List<BoardEntity> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (BoardEntity boardEntity : boardList) {
            BoardDto boardDto = BoardDto.builder()
                    .id(boardEntity.getId())
                    .author(boardEntity.getAuthor())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .createdDate(boardEntity.getCreatedDate())
                    .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    @Transactional
    public BoardDto getPost(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id).orElse(null);
//        Optional<BoardEntity> board2 = Optional.ofNullable(boardRepository.findById(id).orElse(null));
//        Optional<BoardEntity> board3 = boardRepository.findById(id);
        assert boardEntity != null;
        return BoardDto.builder()
                .id(boardEntity.getId())
                .author(boardEntity.getAuthor())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .createdDate(boardEntity.getCreatedDate())
                .build();
    }

    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }
}
