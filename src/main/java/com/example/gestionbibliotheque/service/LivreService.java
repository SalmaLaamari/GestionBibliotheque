package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.CategorieLivre;
import com.example.gestionbibliotheque.bean.Livre;
import com.example.gestionbibliotheque.bean.Reception;
import com.example.gestionbibliotheque.bean.Stock;
import com.example.gestionbibliotheque.dao.LivreDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LivreService {
    @Autowired
    private LivreDao livreDao;
    @Autowired
    private StockService stockService;
    @Autowired
    private CategorieLivreService categorieLivreService;
    @Autowired
    private ReceptionService receptionService;
    public Livre findByReference(String reference) {
        return livreDao.findByReference(reference);
    }

    public List<Livre> findByAuteur(String auteur) {
        return livreDao.findByAuteur(auteur);
    }


    public List<Livre> findByFournisseurLivreReference(String reference) {
        return livreDao.findByFournisseurLivreReference(reference);
    }

    public Optional<Livre> findByTitre(String titre) {
        return livreDao.findByTitre(titre);
    }

    public List<Livre> findByStockReference(String reference) {
        return livreDao.findByStockReference(reference);
    }

    public List<Livre> findByCategorieLivreNom(String nom) {
        return livreDao.findByCategorieLivreNom(nom);
    }

    public List<Livre> findByDatePublication(LocalDateTime date) {
        return livreDao.findByDatePublication(date);
    }

    public List<Livre> findByLangue(String langue) {
        return livreDao.findByLangue(langue);
    }

    public List<Livre> findAll() {
        return livreDao.findAll();
    }

    public void save(Livre livre) {
        Optional<Livre> livreExistant = livreDao.findAll()
                .stream()
                .filter(l -> l.getTitre() != null && l.getTitre().equals(livre.getTitre()))
                .findFirst();
        if (livreExistant.isPresent()) {
            Livre livreToUpdate = livreExistant.get();
            int ancienNombreExemplaires = livre.getNbrEmpreintes();
            livreToUpdate.getReception().setQuantitereceptione(ancienNombreExemplaires);
            int nouveauNombreExemplaires = livreToUpdate.getNbrEmpreintes() + livre.getNbrEmpreintes();
            livreToUpdate.setNbrEmpreintes(nouveauNombreExemplaires);
            int nouvelleQuantite = livreToUpdate.getStock().getQuantite() + livre.getNbrEmpreintes();
            livreToUpdate.getStock().setQuantite(nouvelleQuantite);

            // Mettre à jour les attributs pertinents seulement
            if (livre.getCategorieLivre() != null) {
                livreToUpdate.setCategorieLivre(livre.getCategorieLivre());
            }
            if (livre.getDatePublication() != null) {
                livreToUpdate.setDatePublication(livre.getDatePublication());
            }
            if (livre.getImagesrc() != null) {
                livreToUpdate.setImagesrc(livre.getImagesrc());
            }
            if (livre.getFournisseurLivre() != null) {
                livreToUpdate.setFournisseurLivre(livre.getFournisseurLivre());
            }
            if (livre.getLibrairie() != null) {
                livreToUpdate.setLibrairie(livre.getLibrairie());
            }

            livreDao.save(livreToUpdate);
        } else {
            // Ajouter un nouveau livre
            livre.setNbrEmpreintes(livre.getNbrEmpreintes());

            // Enregistrer la catégorie de livre
            CategorieLivre categorieLivre = livre.getCategorieLivre();
            categorieLivreService.save(categorieLivre);
            livre.setCategorieLivre(categorieLivre);

            // Enregistrer le stock
            Stock stock = livre.getStock();
            stock.setQuantite(livre.getNbrEmpreintes());
            stockService.save(stock);
            livre.setStock(stock);

            // Enregistrer la réception
            Reception reception = livre.getReception();
            reception.setQuantitereceptione(livre.getNbrEmpreintes());
            receptionService.save(reception);
            livre.setReception(reception);

            livreDao.save(livre);
            livre.setReference("Livre-"+livre.getId());
            livreDao.save(livre);
        }
    }

    public int update(Livre livre){
        Livre livre1 = findByReference(livre.getReference());
        if (livre1 != null){
            if (livre.getTitre() != null) {
                livre1.setTitre(livre.getTitre());
            }
            if (livre.getDatePublication() != null) {
                livre1.setDatePublication(livre.getDatePublication());
            }
            if (livre.getCategorieLivre() != null) {
                livre1.setCategorieLivre(livre.getCategorieLivre());
            }
            if (livre.getFournisseurLivre() != null) {
                livre1.setFournisseurLivre(livre.getFournisseurLivre());
            }
            if (livre.getLibrairie() != null) {
                livre1.setLibrairie(livre.getLibrairie());
            }
            if (livre.getStock() != null) {
                livre1.setStock(livre.getStock());
            }
            if (livre.getReception() != null) {
                livre1.setReception(livre.getReception());
            }
            livreDao.save(livre1);
            return 1;
        } else {
            livreDao.save(livre);
            return 2;
        }
    }


    @Transactional
    public void removeOneCopy(String titre) {
        Optional<Livre> livreExistant = livreDao.findByTitre(titre);
        if (livreExistant.isPresent()) {
            Livre livreToUpdate = livreExistant.get();
            int nouveauNombreExemplaires = (int) livreToUpdate.getNbrEmpreintes() - 1;
            if (nouveauNombreExemplaires >= 0) {
                livreToUpdate.setNbrEmpreintes(nouveauNombreExemplaires);
                livreDao.save(livreToUpdate);
            } else {
                throw new RuntimeException("Cannot remove copy: Book already has zero copies");
            }
        } else {
            throw new RuntimeException("Cannot remove copy: Book not found");
        }
    }
    @Transactional
    public void deleteById(Long id) {
        Optional<Livre> livreOptional = livreDao.findById(id);
        if (livreOptional.isPresent()) {
            Livre livre = livreOptional.get();
            Stock stock = livre.getStock();
            Reception reception = livre.getReception();
            livreDao.delete(livre);
            stockService.deleteByReference(stock.getReference());
            receptionService.deleteByReference(reception.getReference());
        } else {
            throw new IllegalArgumentException("Le livre avec l'ID " + id + " n'existe pas.");
        }
    }


}
