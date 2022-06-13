package study.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.board.domain.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
