package com.app.bluecotton.api.publicapi;

import com.app.bluecotton.domain.vo.chat.ChatMessageVO;
import com.app.bluecotton.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats/*")
@RequiredArgsConstructor
public class ChatMessagesApi {

    private final ChatMessageService chatMessageService;

    // 채팅방 메시지 불러오기
    @GetMapping("/get-messages/{myChatRoomId}")
    public List<ChatMessageVO> getChats(@PathVariable Long chatId) {
        ChatMessageVO chatMessageVO = new ChatMessageVO();
        chatMessageVO.setChatId(chatId);
        return chatMessageService.selectAll(chatMessageVO);
    }

    // 읽음 처리
    @PatchMapping("/read/{myChatRoomId}/{customerReceiverId}")
    public void markAsRead(@PathVariable Long chatId, @PathVariable Long memberReceiverId) {
        ChatMessageVO chatMessageVO = new ChatMessageVO();
        chatMessageVO.setChatId(chatId);
        chatMessageVO.setChatMessageReceiverId(memberReceiverId);
        chatMessageService.updateReadStatus(chatMessageVO);
    }
}