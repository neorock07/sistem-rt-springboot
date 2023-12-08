package com.sifora.sifora.Services.AnggotaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sifora.sifora.DTO.AnggotaDTO;
import com.sifora.sifora.Entity.Anggota;
import com.sifora.sifora.Repository.RepoAnggota;

@Service
public class AnggotaService {

    @Autowired
    RepoAnggota repo;

    // @Autowired
    // RepoUser repoUser;

    // @Autowired
    // RepoKeluarga repoKeluarga;

    public Anggota create(AnggotaDTO req){
        Anggota anggota = new Anggota();
        anggota.setId(req.getId());
        anggota.setAlamat(req.getAlamat());
        anggota.setBangsa(req.getBangsa());
        anggota.setJenis_kelamin(req.getJenis_kelamin());
        anggota.setKecamatan(req.getKecamatan());
        anggota.setKota(req.getKota());
        anggota.setNo_telp(req.getNo_telp());
        anggota.setPekerjaan(req.getPekerjaan());
        anggota.setProv(req.getProv());
        anggota.setTempat_lahir(req.getTempat_lahir());
        anggota.setNegara(req.getNegara());
        anggota.setNama(req.getNama());
        anggota.setTgl_lahir(req.getTgl_lahir());
        // anggota.setUser_id(req.getUser_id());
        anggota.setKeluarga_id(req.getKeluarga_id());
        // anggota.setUser_id(user);
        // anggota.setKeluarga_id(kel);
        return repo.save(anggota);
    }

    public List<Anggota> findAll(){
        return repo.findAll();
    }

}
