package com.lxisoft.service;

import com.lxisoft.model.Dialogue;
import com.lxisoft.repository.DialogueReppo;
import com.lxisoft.repository.DialogueReppo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DialogueService {
    @Autowired
    private DialogueReppo dialogueReppo;

    @Transactional
    public List<Dialogue> getAllDialogue()
    {
        return dialogueReppo.findAll();
    }

    @Transactional
    public void saveDialogue(Dialogue dialogue)
    {
        dialogueReppo.save(dialogue);
    }
    @Transactional
    public  void deleteDialogue(int dilgId)
    {
        dialogueReppo.deleteById(dilgId);
    }

}

