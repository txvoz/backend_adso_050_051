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
        entity.setColor(dto.getColor()); // Hexadecimal #ff00011
        entity.setBornDate(dto.getBornDate()); // Sea mayor de edd
        entity.setEmail(dto.getEmail()); // formato email
        entity.setPhone(dto.getPhone()); // formato telefono valido para colombia

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

    public UserDto getById(Long id){
        UserEntity entity = this.repository.findById(id).get();

        UserDto dto = new UserDto();

        dto.setFullName(entity.getFullName());
        dto.setColor(entity.getColor());
        dto.setEmail(entity.getEmail());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setId(entity.getId());
        dto.setBornDate(entity.getBornDate());

        return dto;
    }

    public void update(UserDto dto, Long id){
        UserEntity entity = this.repository.findById(id).get();

        entity.setFullName(dto.getFullName());
        entity.setColor(dto.getColor());
        entity.setBornDate(dto.getBornDate());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());

        this.repository.save(entity);
    }

    public void delete(Long id){
        UserEntity entity = this.repository.findById(id).get();
        this.repository.deleteById(id);
    }


}
