package com.libreria.api.Models;

import com.libreria.api.Genere;
import jakarta.persistence.*;

@Entity
@Table(name = "libri")
public class Libro{
    private @Id
    @GeneratedValue
    Long id;
    @Column(nullable = false)
    private String titolo;
    @Column(nullable = false)
    private String autore;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genere genere;
    @ManyToOne(fetch = FetchType.LAZY) //fetch è richiamare e .LAZY definisce il modo in cui viene richiamato. lazy richiama il dato solo quando richiesto
    @JoinColumn(name = "scaffale_id")
    private Scaffale scaffale;
    //JoinColumn serve a controllare esplicitamente la colonna della chiave esterna nel database, invece di lasciare che Hibernate decida tutto da solo.
    //La colonna verrebbe comunque creata da sola anche senza @JoinColumn ma così puoi controllare il nome e volendo anche altri parametri come mettergli dentro il nullable=false per evitare che venga lasciato vuoto
    //In questo caso JoinColumn serve al libro per capire a quelle scaffale appartiene. Ad esempio allo scaffale con id 1

    public Libro() {}
    public Libro(String titolo, String autore, Genere genere){
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
    }

    public void setTitolo(String titolo){this.titolo = titolo;}
    public String getTitolo(){return titolo;}

    public void setAutore(String autore){this.autore = autore;}
    public String getAutore(){return autore;}

    public void setGenere(Genere genere){this.genere = genere;}
    public Genere getGenere(){return genere;}

    public void setScaffale(Scaffale scaffale) { this.scaffale = scaffale; }
    public Scaffale getScaffale() { return scaffale; }

    public Long getId(){return id;}
}