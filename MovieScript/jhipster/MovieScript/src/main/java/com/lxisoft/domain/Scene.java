package com.lxisoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Scene.
 */
@Entity
@Table(name = "scene")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Scene implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "scene_detail")
    private String sceneDetail;

    @ManyToOne
    @JsonIgnoreProperties(value = "scenes", allowSetters = true)
    private Movie movie;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSceneDetail() {
        return sceneDetail;
    }

    public Scene sceneDetail(String sceneDetail) {
        this.sceneDetail = sceneDetail;
        return this;
    }

    public void setSceneDetail(String sceneDetail) {
        this.sceneDetail = sceneDetail;
    }

    public Movie getMovie() {
        return movie;
    }

    public Scene movie(Movie movie) {
        this.movie = movie;
        return this;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Scene)) {
            return false;
        }
        return id != null && id.equals(((Scene) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Scene{" +
            "id=" + getId() +
            ", sceneDetail='" + getSceneDetail() + "'" +
            "}";
    }
}
