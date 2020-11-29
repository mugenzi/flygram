package com.flygram.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flygram.Domain.AccountPrivacy;
import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.EAccountPrivacy;
import com.flygram.dao.AccountPrivacyDao;
import com.flygram.service.IAccountPrivacyService;

@Service
@Transactional
public class AccountPrivacyServiceImpl implements IAccountPrivacyService {

	private static final Logger LOGGER = Logger.getLogger(AccountProfileServiceImpl.class);

	@Autowired
	private AccountPrivacyDao dao;

	@Override
	public AccountPrivacy createAccountPrivacy(AccountPrivacy privacy) {
		AccountPrivacy object = null;
		try {
			object = dao.save(privacy);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public AccountPrivacy updateAccountPrivacy(AccountPrivacy privacy) {
		AccountPrivacy object = null;
		try {
			AccountPrivacy accountToUpdate = (AccountPrivacy) dao.findById(privacy.getId());
			object = dao.save(accountToUpdate);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public void deleteAccountPrivacy(AccountPrivacy privacy) {
		try {
			AccountPrivacy accountToDelete = (AccountPrivacy) dao.findById(privacy.getId());
			dao.delete(accountToDelete);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
	}

	@Override
	public AccountPrivacy findAccountPrivacyById(long id) {
		AccountPrivacy object = null;
		try {
			object = (AccountPrivacy) dao.findById(id);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public AccountPrivacy findAccountPrivacyByAccount(AccountProfile account) {
		AccountPrivacy object = null;
		try {
			object = (AccountPrivacy) dao.findByAccount(account);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public List<AccountPrivacy> findAccountPrivacyByPrivacy(EAccountPrivacy privacy) {
		List<AccountPrivacy> object = new ArrayList<>();
		try {
			object = dao.findByPrivacy(privacy);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public List<AccountPrivacy> findAllAccountPrivacy() {
		List<AccountPrivacy> object = new ArrayList<>();
		try {
			object = dao.findAll();
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

}
