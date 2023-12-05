package edu.co.sena.apiclient.services;

import edu.co.sena.apiclient.contracts.UserDto;
import edu.co.sena.apiclient.entities.UserEntity;
import edu.co.sena.apiclient.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void create(UserDto dto){
        UserEntity entity = new UserEntity();

        entity.setFullName(dto.getFullName());
        entity.setColor(dto.getColor());
        entity.setBornDate(dto.getBornDate());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());

        //yo debo hacer las validaciones de negocio


        this.repository.save(entity);
    }

    public List<UserDto> getAllUsers(){
        List<UserEntity> usuarios = this.repository.findAll();
        ArrayList<UserDto> dtos = new ArrayList<>();

        for (int i = 0; i < usuarios.size(); i++) {
            UserEntity currentEntity = usuarios.get(i);
            UserDto dto = new UserDto();

            dto.setFullName(currentEntity.getFullName());
            dto.setColor(currentEntity.getColor());
            dto.setEmail(currentEntity.getEmail());
            dto.setEmail(currentEntity.getEmail());
            dto.setPhone(currentEntity.getPhone());
            dto.setId(currentEntity.getId());
            dto.setBornDate(currentEntity.getBornDate());

            dtos.add(dto);
        }

        return dtos;
    }


}
