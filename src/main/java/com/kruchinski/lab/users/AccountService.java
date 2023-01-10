package com.kruchinski.lab.users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        super();
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = accountRepository.findByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public Account findAccountById(Long userId) {
        Optional<Account> userFromDb = accountRepository.findById(userId);
        return userFromDb.orElse(new Account());
    }

    public List<Account> allUsers() {
        return accountRepository.findAll();
    }

    public boolean saveUser(Account user) {
        Account userFromDB = accountRepository.findByLogin(user.getUsername());

        if (userFromDB != null) {
            System.out.println("user in db");
            return false;
        }
        System.out.println(user);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        user.setRoles(Collections.singleton(new Role(1L, "USER")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        accountRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (accountRepository.findById(userId).isPresent()) {
            accountRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<Account> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM Account u WHERE u.id > :paramId", Account.class)
                .setParameter("paramId", idMin).getResultList();
    }

}
