package br.com.afroglow.backendAfroGlow.Service;

import br.com.afroglow.backendAfroGlow.Models.Admin;
import br.com.afroglow.backendAfroGlow.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void adicionarAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public Admin visualizarAdmin(Integer adminId) {
        Optional<Admin> adminOptional = adminRepository.findById(adminId);
        return adminOptional.orElse(null);
    }

    public void atualizarAdmin(Admin admin) {
        adminRepository.save(admin);
    }

  
}
