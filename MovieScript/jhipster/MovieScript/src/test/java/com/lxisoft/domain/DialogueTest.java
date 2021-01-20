package com.lxisoft.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.lxisoft.web.rest.TestUtil;

public class DialogueTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Dialogue.class);
        Dialogue dialogue1 = new Dialogue();
        dialogue1.setId(1L);
        Dialogue dialogue2 = new Dialogue();
        dialogue2.setId(dialogue1.getId());
        assertThat(dialogue1).isEqualTo(dialogue2);
        dialogue2.setId(2L);
        assertThat(dialogue1).isNotEqualTo(dialogue2);
        dialogue1.setId(null);
        assertThat(dialogue1).isNotEqualTo(dialogue2);
    }
}
