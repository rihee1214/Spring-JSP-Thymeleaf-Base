package com.iu.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.board.BoardService;
import com.iu.s1.board.BoardVO;
import com.iu.s1.util.Pager;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		return noticeMapper.getList(pager);
	}

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return noticeMapper.getTotalCount(pager);
	}


	@Override
	public Long setBoard(BoardVO boardVO) throws Exception {
		return noticeMapper.setBoard(boardVO);
	}

	@Override
	public Long setUpdate(BoardVO boardVO) throws Exception {
		return noticeMapper.setUpdate(boardVO);
	}

	@Override
	public Long setHitUpdate(BoardVO boardVO) throws Exception {
		return noticeMapper.setHitUpdate(boardVO);
	}

	@Override
	public Long setDelete(BoardVO boardVO) throws Exception {
		return noticeMapper.setDelete(boardVO);
	}

	@Override
	public BoardVO getSelect(BoardVO boardVO) throws Exception {
		return noticeMapper.getSelect(boardVO);
	}

	
}
