package com.app.bluecotton.service;

import com.app.bluecotton.domain.vo.chat.ChatVO;
import com.app.bluecotton.exception.ChatException;
import com.app.bluecotton.repository.ChatDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatDAO chatDAO;

    @Override
    public void createChat(ChatVO chatVO) {
        chatDAO.save(chatVO);
    }

    @Override
    public ChatVO selectChatById(Long id) {
        return chatDAO.findById(id).orElseThrow(() -> new ChatException("채팅방이 없습니다."));
    }

    @Override
    public List<ChatVO> selectAll() {
        return chatDAO.findAll();
    }

    @Override
    public void delete(Long id) {
        chatDAO.delete(id);
    }

    @Override
    public List<ChatVO> selectChatListByMember(Long memberId) {
        return chatDAO.findByMemberId(memberId);
    }
}
