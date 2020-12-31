package com.lxisoft.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Movie.
 */
@Entity
@Table(name = "movie")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "movie_details")
    private String movieDetails;

    @OneToMany(mappedBy = "movie")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Actor> actors = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Scene> scenes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public Movie movieName(String movieName) {
        this.movieName = movieName;
        return this;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDetails() {
        return movieDetails;
    }

    public Movie movieDetails(String movieDetails) {
        this.movieDetails = movieDetails;
        return this;
    }

    public void setMovieDetails(String movieDetails) {
        this.movieDetails = movieDetails;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public Movie actors(Set<Actor> actors) {
        this.actors = actors;
        return this;
    }

    public Movie addActor(Actor actor) {
        this.actors.add(actor);
        actor.setMovie(this);
        return this;
    }

    public Movie removeActor(Actor actor) {
        this.actors.remove(actor);
        actor.setMovie(null);
        return this;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Scene> getScenes() {
        return scenes;
    }

    public Movie scenes(Set<Scene> scenes) {
        this.scenes = scenes;
        return this;
    }

    public Movie addScene(Scene scene) {
        this.scenes.add(scene);
        scene.setMovie(this);
        return this;
    }

    public Movie removeScene(Scene scene) {
        this.scenes.remove(scene);
        scene.setMovie(null);
        return this;
    }

    public void setScenes(Set<Scene> scenes) {
        this.scenes = scenes;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Movie)) {
            return false;
        }
        return id != null && id.equals(((Movie) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Movie{" +
            "id=" + getId() +
            ", movieName='" + getMovieName() + "'" +
            ", movieDetails='" + getMovieDetails() + "'" +
            "}";
    }
}
