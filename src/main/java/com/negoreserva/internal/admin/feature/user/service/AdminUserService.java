package com.negoreserva.internal.admin.feature.user.service;

import com.negoreserva.common.feature.concrete.user.dto.queryparam.UserFilterQueryParam;
import com.negoreserva.common.feature.concrete.user.exception.notfound.UserEmailNotFoundException;
import com.negoreserva.common.feature.concrete.user.exception.notfound.UserNotFoundException;
import com.negoreserva.common.feature.concrete.user.exception.notfound.UserPhoneNotFoundException;
import com.negoreserva.common.feature.concrete.user.exception.notfound.UserUsernameNotFoundException;
import com.negoreserva.common.util.PasswordEncoderGenerator;
import com.negoreserva.internal.admin.feature.user.query.UserFilterSpecification;
import com.negoreserva.internal.admin.feature.user.repository.AdminUserRepo;
import com.negoreserva.common.feature.concrete.user.dto.response.UserPaginate;
import com.negoreserva.common.feature.concrete.user.model.User;
import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import com.negoreserva.common.feature.core.service.ConcreteService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AdminUserService extends ConcreteService<User> {
    private final AdminUserRepo repository;

    public AdminUserService(AdminUserRepo repository) {
        super(repository);
        this.repository = repository;
    }

    public UserPaginate paginate(Pageable pageable) {
        var page = repository.findAll(pageable);
        return UserPaginate.of(page);
    }

    public UserPaginate paginate(PaginateRequest paginateRequest) {
        return paginate(PageRequest.of(paginateRequest.pageNumber(), paginateRequest.pageSize()));
    }

    public UserPaginate paginate(UserFilterQueryParam filter) {
        var pageRequest = PageRequest.of(
                Optional.of(filter.getPageNumber()).orElse(0),
                Optional.of(filter.getPageSize()).orElse(10)
        );
        var spec = new UserFilterSpecification(filter);
        var page = findAll(spec, pageRequest);
        return UserPaginate.of(page);
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new UserUsernameNotFoundException(username));
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new UserEmailNotFoundException(email));
    }

    public User findByPhone(String phone) {
        return repository.findByPhone(phone).orElseThrow(() -> new UserPhoneNotFoundException(phone));
    }

    public User findByUuid(UUID uuid) {
        return repository.findByUuid(uuid).orElseThrow(() -> new UserNotFoundException(uuid));
    }

    @Override
    public User update(UUID uuid, User data) {
        var item = findByUuid(uuid);
        item.setBirthday(data.getBirthday());
        item.setName(data.getName());
        return repository.save(item);
    }

    @Override
    public User save(User data) {
        data.setPassword(PasswordEncoderGenerator.encode(data.getPassword()));
        return super.save(data);
    }

    public User findOrCreate(User user) {
        return repository.findByEmail(user.getEmail()).orElseGet(() -> save(user));
    }
}
