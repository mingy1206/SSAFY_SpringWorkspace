package com.board;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
public interface BoardDAO {
	ArrayList<Board> selectAll() throws Exception;//모든글 목록
	Board selectOne(String num)throws Exception;//해당 번호의 글 한 개
	int insert(Board b)throws Exception;//새글 등록
	int delete(String num)throws Exception;//해당 번호의 글 삭제

}
