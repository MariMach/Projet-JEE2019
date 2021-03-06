package org.Metier;

import java.util.List;

import org.dao.CompteUserRepository;
import org.dao.CompteVerificationPepository;
import org.entities.CompteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteUserMetierImpl implements CompteUserMetier{
	
	@Autowired
	private CompteUserRepository compteUserRepository;

	@Autowired
	private CompteVerificationPepository compteVerificationRepository;

	@Override
	public CompteUser saveCompteUser(CompteUser cu) {
		// TODO Auto-generated method stub
		if(compteVerificationRepository.getOne(cu.getCinU()) != null) {
			return compteUserRepository.save(cu);
		} else {
			return null;
		}
	}

	@Override
	public List<CompteUser> listCompteUsers() {
		// TODO Auto-generated method stub
		return compteUserRepository.findAll();
	}

	@Override
	public CompteUser getCompteUserByCode(String cin) {
		// TODO Auto-generated method stub
		return compteUserRepository.getOne(cin);
	}

}
