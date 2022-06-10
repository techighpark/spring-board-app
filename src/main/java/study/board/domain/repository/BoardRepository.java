package study.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.board.domain.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
