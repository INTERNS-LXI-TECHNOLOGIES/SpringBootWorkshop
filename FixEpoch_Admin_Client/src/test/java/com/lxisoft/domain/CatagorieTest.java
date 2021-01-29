package com.lxisoft.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.lxisoft.web.rest.TestUtil;

public class CatagorieTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Catagorie.class);
        Catagorie catagorie1 = new Catagorie();
        catagorie1.setId(1L);
        Catagorie catagorie2 = new Catagorie();
        catagorie2.setId(catagorie1.getId());
        assertThat(catagorie1).isEqualTo(catagorie2);
        catagorie2.setId(2L);
        assertThat(catagorie1).isNotEqualTo(catagorie2);
        catagorie1.setId(null);
        assertThat(catagorie1).isNotEqualTo(catagorie2);
    }
}
