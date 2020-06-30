package com.lxisoft.mockexam.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;

/**
 * The Exam entity.
 */
@ApiModel(description = "The Exam entity.")
@Entity
@Table(name = "exam")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "exam")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "opt_1")
    private String opt1;

    @Column(name = "opt_2")
    private String opt2;

    @Column(name = "opt_3")
    private String opt3;

    @Column(name = "opt_4")
    private String opt4;

    @Column(name = "answer")
    private String answer;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public Exam question(String question) {
        this.question = question;
        return this;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return opt1;
    }

    public Exam opt1(String opt1) {
        this.opt1 = opt1;
        return this;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public Exam opt2(String opt2) {
        this.opt2 = opt2;
        return this;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public Exam opt3(String opt3) {
        this.opt3 = opt3;
        return this;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public Exam opt4(String opt4) {
        this.opt4 = opt4;
        return this;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public String getAnswer() {
        return answer;
    }

    public Exam answer(String answer) {
        this.answer = answer;
        return this;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Exam)) {
            return false;
        }
        return id != null && id.equals(((Exam) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Exam{" +
            "id=" + getId() +
            ", question='" + getQuestion() + "'" +
            ", opt1='" + getOpt1() + "'" +
            ", opt2='" + getOpt2() + "'" +
            ", opt3='" + getOpt3() + "'" +
            ", opt4='" + getOpt4() + "'" +
            ", answer='" + getAnswer() + "'" +
            "}";
    }
}
