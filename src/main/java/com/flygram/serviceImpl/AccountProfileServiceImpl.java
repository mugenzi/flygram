package com.flygram.serviceImpl;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.EAccountPrivacy;
import com.flygram.Domain.EAccountProfileStatus;
import com.flygram.Domain.User;
import com.flygram.dao.AccountProfileDao;
import com.flygram.service.IAccountProfileService;
import com.util.FlyGramConstant;

@Service
@Transactional
public class AccountProfileServiceImpl implements IAccountProfileService {

	private static final Logger LOGGER = Logger.getLogger(AccountProfileServiceImpl.class);

	@Autowired
	private AccountProfileDao dao;

	@Autowired
	ServletContext context;

	@Autowired
	ServletContext servletContext;

	@Override
	public AccountProfile createAccountProfile(AccountProfile account) {
		AccountProfile object = null;
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("default.png");
			byte[] fileContent = readBytes(inputStream);

			account.setPrivacy(EAccountPrivacy.PUBLIC);
			account.setCreationDate(LocalDateTime.now());
			account.setStatus(EAccountProfileStatus.ACTIVE);
			if (account.getProfilePic() == null)
				account.setProfilePic(fileContent);
			object = dao.save(account);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public AccountProfile updateAccountProfile(AccountProfile account) {
		AccountProfile object = null;
		try {
			AccountProfile accountToUpdate = (AccountProfile) dao.findById(account.getAccountId());
			object = dao.save(accountToUpdate);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public void deleteAccountProfile(AccountProfile account) {
		try {
			AccountProfile accountToDelete = (AccountProfile) dao.findById(account.getAccountId());
			dao.delete(accountToDelete);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
	}

	@Override
	public AccountProfile findAccountProfileById(long id) {
		AccountProfile object = null;
		try {
			object = (AccountProfile) dao.findById(id);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public AccountProfile findAccountProfileByUser(User user) {
		AccountProfile object = null;
		try {
			object = (AccountProfile) dao.findByUser(user);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@Override
	public List<AccountProfile> viewAccountProfile() {
		List<AccountProfile> list = new ArrayList<>();
		try {
			list = (List<AccountProfile>) dao.findAll();
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}

	public byte[] readBytes(InputStream stream) throws IOException {
		if (stream == null)
			return new byte[] {};
		byte[] buffer = new byte[1024];
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		boolean error = false;
		try {
			int numRead = 0;
			while ((numRead = stream.read(buffer)) > -1) {
				output.write(buffer, 0, numRead);
			}
		} catch (IOException e) {
			error = true; // this error should be thrown, even if there is an error closing stream
			throw e;
		} catch (RuntimeException e) {
			error = true; // this error should be thrown, even if there is an error closing stream
			throw e;
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				if (!error)
					throw e;
			}
		}
		output.flush();
		return output.toByteArray();
	}

	@Override
	public AccountProfile getLoggedAccountProfile() {
		AccountProfile profile = (AccountProfile) servletContext.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
		return profile;
	}

	public Image getImageFile(byte[] fileContent) {
		try {
			//
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return null;
	}

}
