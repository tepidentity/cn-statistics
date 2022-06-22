package org.example.data.source.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
@Table(name = "statistics", uniqueConstraints = @UniqueConstraint(columnNames={"country_id", "date"}))
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "new_confirmed")
    private long newConfirmed;

    @Column(name = "total_confirmed")
    private long totalConfirmed;

    @Column(name = "new_deaths")
    private long newDeaths;

    @Column(name = "total_deaths")
    private long totalDeaths;

    @Column(name = "new_recovered")
    private long newRecovered;

    @Column(name = "total_recovered")
    private long totalRecovered;

    @Column(name = "date", nullable = false)
    private Instant date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id", nullable=false)
    private Country country;
}
