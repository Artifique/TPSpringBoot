package com.example.gest_ticket.service.Implementation;

import com.example.gest_ticket.modele.BaseConnaissance;
import com.example.gest_ticket.repository.BaseConnaissanceRepository;
import com.example.gest_ticket.service.BaseConnaissanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseServiceImpl implements BaseConnaissanceService {
    @Autowired
    private BaseConnaissanceRepository baseConnaissanceRepository;
    @Override
    public BaseConnaissance creerBase(BaseConnaissance baseConnaissance) {
        return baseConnaissanceRepository.save(baseConnaissance);
    }

    @Override
    public BaseConnaissance modifierBase(Long id, BaseConnaissance baseConnaissance) {
        return baseConnaissanceRepository.findById(id)
                .map(baseConnaissance1 -> {
                    baseConnaissance1.setTitre(baseConnaissance.getTitre());
                    baseConnaissance1.setContenu(baseConnaissance.getContenu());
                    baseConnaissance1.setDate_creation(baseConnaissance.getDate_creation());
                    baseConnaissance1.setDate_modification(baseConnaissance.getDate_modification());
                    return baseConnaissanceRepository.save(baseConnaissance1);
                }).orElseThrow(()-> new RuntimeException("Ce contenu n'existe pas"));

    }

    @Override
    public String supprimerBase(Long id) {
        baseConnaissanceRepository.deleteById(id);
        return "La Base a été supprimée";
    }

    @Override
    public List<BaseConnaissance> listBase() {
        return baseConnaissanceRepository.findAll();
    }
}
